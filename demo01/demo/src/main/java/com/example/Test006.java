package com.example;

/**
 * Test006
 * 空間計算量 $O(1)$・時間計算量 $O(\log(\min(m, n)))$ 
 */
class Test006 {
    // ローカル実行用の main メソッド
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {4, 5, 6};
        
        double result = Test006.findMedianSortedArrays(nums1, nums2);
        
        // 結果を出力 (出力例: 2.0)
        System.out.println(result);
    }

    /**
     * 2つのソート済み配列の中央値を求めるメインメソッド
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        
        // 【総数が奇数の場合】
        // 例: 全体で5個の場合、真ん中は (5 / 2) + 1 = 3番目（1-indexed）
        if (totalLen % 2 == 1) {
            return findKth(nums1, nums2, totalLen / 2 + 1);
        } 
        // 【総数が偶数の場合】
        // 例: 全体で4個の場合、真ん中は 2番目 と 3番目の平均値
        else {
            int leftVal = findKth(nums1, nums2, totalLen / 2);
            int rightVal = findKth(nums1, nums2, totalLen / 2 + 1);
            return (leftVal + rightVal) / 2.0;
        }
    }

    /**
     * 2つのソート済み配列から、全体で「k番目」（1-indexed）に小さい要素を
     * バイナリサーチの要領で爆発的に高速に特定するコアロジック。
     */
    private static int findKth(int[] nums1, int[] nums2, int k) {
        int start1 = 0; // nums1 における現在の探索開始位置
        int start2 = 0; // nums2 における現在の探索開始位置

        while (true) {
            int len1 = nums1.length - start1; // nums1 の残り探索範囲の長さ
            int len2 = nums2.length - start2; // nums2 の残り探索範囲の長さ

            // 【不変条件の正規化】
            // 常に「nums1 の残り長さ <= nums2 の残り長さ」が成り立つようにする。
            // これにより、短い方の配列を基準にして安全にインデックスを計算できる。
            if (len1 > len2) {
                return findKth(nums2, nums1, k); // 引数の順番を入れ替えて再帰（またはループ継続）
            }

            // 【エッジケース1：片方の配列が完全に枯渇した場合】
            // 短い方の配列（nums1）の要素がすべて除外された場合、
            // 残りの答えはもう一方の配列（nums2）の先頭から k 番目の位置にある。
            if (len1 == 0) {
                return nums2[start2 + k - 1];
            }

            // 【エッジケース2：k が 1 に到達した場合】
            // 1番目に小さい要素を求めているため、両方の配列の現在の先頭要素のうち、小さい方を返す。
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }

            // 【肝となる分割ステップ】
            // k 個の要素を効率的に削るため、各配列から最大 (k / 2) 個目の要素を比較する。
            // ただし、配列の残りの長さ（len1）を超えることはできないため、minを取る。
            int i = Math.min(len1, k / 2);
            int j = k - i; // nums2 側から削るべき個数（合計で k 個になるように調整）

            // 比較対象となるインデックス（0-indexed なので -1 をする）
            int mid1 = start1 + i - 1;
            int mid2 = start2 + j - 1;

            // 【核心の枝分かれ】
            // nums1 の中点の方が小さいということは、
            // nums1[start1 ... mid1] までの i 個の要素は、すべて求める「k番目の値」よりも小さい。
            // したがって、これらは将来の候補から一括して除外できる。
            if (nums1[mid1] < nums2[mid2]) {
                start1 += i; // nums1 の探索開始位置を i 個進める（左側を切り捨てる）
                k -= i;      // 除外した分だけ、探すべき k の数値を減らす
            } 
            // 逆側のケース：nums2 側の方が小さい場合
            else {
                start2 += j; // nums2 の探索開始位置を j 個進める
                k -= j;      // 探すべき k の数値を減らす
            }
        }
    }
    
}