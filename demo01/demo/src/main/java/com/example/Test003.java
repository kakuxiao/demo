package com.example;

public class Test003 {

    /**
     * メモ化テーブル：memo[length][l1][l2]
     * - length: 考察対象の部分文字列の長さ（1からnまで）
     * - l1: 文字列 s1 の部分文字列の開始インデックス
     * - l2: 文字列 s2 の部分文字列の開始インデックス
     * - 値の意味: 0 は未計算、1 は true（スクランブル文字列である）、-1 は false。
     * 3次元配列を使用することで、頻繁な文字列オブジェクトの生成による GC 負荷やオートボクシングのオーバーヘッドを完全に回避します。
     */
    private byte[][][] memo;

    /**
     * メインメソッド：スクランブル文字列判定アルゴリズムのテストと検証のエントリポイント。
     */
    public static void main(String[] args) {
        Test003 solution = new Test003();
        
        // テストケース 1：一致するケース、true が出力されるべき
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println("Result 1: " + solution.isScramble(s1, s2)); // 期待値: true

        // テストケース 2：スクランブルで生成できないケース、false が出力されるべき
        String s1_2 = "abcde";
        String s2_2 = "caebd";
        System.out.println("Result 2: " + solution.isScramble(s1_2, s2_2)); // 期待値: false
    }

    /**
     * 公開メソッド：文字列 s2 が s1 のスクランブル文字列（Scramble String）であるかどうかを判定します。
     * 
     * @param s1 元の文字列
     * @param s2 比較対象の文字列
     * @return s2 が s1 のスクランブル文字列である場合は true、そうでない場合は false
     */
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        
        // 早期リターン：2つの文字列の長さが異なる場合、スクランブル関係になり得ない
        if (n != s2.length()) {
            return false;
        }
        
        // メモ化配列の初期化、サイズは [n + 1][n][n]
        memo = new byte[n + 1][n][n];
        
        // 文字列全体の区間（s1 の [0, n-1] と s2 の [0, n-1]）から深さ優先探索を開始する
        return dfs(s1, 0, n - 1, s2, 0, n - 1);
    }

    /**
     * 深さ優先探索（DFS）とメモ化再帰のコア関数：
     * s1 のインデックス l1 から r1 までの部分文字列と、s2 のインデックス l2 から r2 までの部分文字列が
     * スクランブル関係にあるかどうかを判定します。
     */
    private boolean dfs(String s1, int l1, int r1, String s2, int l2, int r2) {
        // 最適化 1：文字列が完全に一致する場合は、即座に true を返す
        if (isSubstringEqual(s1, l1, r1, s2, l2, r2)) {
            return true;
        }

        // 現在の部分文字列の長さを計算
        int length = r1 - l1 + 1;

        // 最適化 2：長さが 1 の場合（かつ上記で完全一致しなかった場合）、異なる文字なので false
        if (length == 1) {
            return false;
        }

        // 最適化 3：メモ化の確認。すでに計算済みの場合はキャッシュ結果を返す
        if (memo[length][l1][l2] != 0) {
            return memo[length][l1][l2] == 1;
        }

        // 最適化 4：文字頻度による強力な枝刈り（Pruning）。
        // 含まれる文字の種類や数が異なる場合、どのように分割してもスクランブル関係にはならない。
        if (!hasSameChars(s1, l1, r1, s2, l2)) {
            memo[length][l1][l2] = -1; // 不可能としてキャッシュ
            return false;
        }

        // すべての可能な分割点 i を試行（i は左側部分文字列の長さ、1 から length - 1 まで）
        for (int i = 1; i < length; i++) {
            
            // --- パターン 1：左右を交換しない場合 ---
            // s1 の左半分 [l1, l1 + i - 1] が s2 の左半分 [l2, l2 + i - 1] にマッチし、
            // かつ s1 の右半分 [l1 + i, r1] が s2 の右半分 [l2 + i, r2] にマッチする
            if (dfs(s1, l1, l1 + i - 1, s2, l2, l2 + i - 1) && 
                dfs(s1, l1 + i, r1, s2, l2 + i, r2)) {
                memo[length][l1][l2] = 1; // 可能としてキャッシュ
                return true;
            }

            // --- パターン 2：左右をクロスして交換する場合 ---
            // s1 の左半分 [l1, l1 + i - 1] が s2 の右半分 [r2 - i + 1, r2] にマッチし、
            // かつ s1 の右半分 [l1 + i, r1] が s2 の左半分 [l2, r2 - i] にマッチする
            if (dfs(s1, l1, l1 + i - 1, s2, r2 - i + 1, r2) && 
                dfs(s1, l1 + i, r1, s2, l2, r2 - i)) {
                memo[length][l1][l2] = 1; // 可能としてキャッシュ
                return true;
            }
        }

        // どの分割方法でも一致しない場合、不可能としてキャッシュして false を返す
        memo[length][l1][l2] = -1;
        return false;
    }

    /**
     * 補助メソッド：新しい String オブジェクトを生成せず、直接インデックスで2つの部分文字列が等しいか比較する
     */
    private boolean isSubstringEqual(String s1, int l1, int r1, String s2, int l2, int r2) {
        if (r1 - l1 != r2 - l2) {
            return false;
        }
        for (int i = 0; i <= r1 - l1; i++) {
            if (s1.charAt(l1 + i) != s2.charAt(l2 + i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 補助メソッド：文字頻度統計による高速な枝刈り。
     * 長さ 26 の配列を使用して、2つの部分文字列内の各アルファベット（a-z）の出現回数の差分を計算する。
     */
    private boolean hasSameChars(String s1, int l1, int r1, String s2, int l2) {
        int[] count = new int[26];
        int len = r1 - l1 + 1;
        
        for (int i = 0; i < len; i++) {
            count[s1.charAt(l1 + i) - 'a']++;
            count[s2.charAt(l2 + i) - 'a']--;
        }
        
        for (int c : count) {
            if (c != 0) {
                return false; // 文字の種類または数量が一致しない
            }
        }
        return true;
    }
}