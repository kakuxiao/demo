package com.example.code.generated;

public class NumSquares {
    /**
     * 279. 完全平方数
     * n を完全平方数の和で表すときに必要な最小個数を返します。
     *
     * <p>たとえば 12 は 4 + 4 + 4 なので 3、13 は 9 + 4 なので 2 です。</p>
     *
     * <p>一般的な DP では、0 から n までの答えを配列に保存して
     * O(n√n) 時間、O(n) 追加領域を使います。この実装では数論の性質を使い、
     * 答えが必ず 1、2、3、4 のいずれかになることを利用します。</p>
     *
     * @param n 表したい非負整数
     * @return n を表す完全平方数の最小個数
     * @throws IllegalArgumentException n が負の場合
     */
    public int numSquares(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n は0以上で指定してください: " + n);
        }
        
        int[] dp = new int[n + 1];
       

        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

  


    public static void main(String[] args) {
        NumSquares solution = new NumSquares();

    
        // 1個の例: 16 自体が 4^2 なので、答えは1です。
        printExample(solution, 16, "16 = 4^2");

        // 2個の例: 13 = 3^2 + 2^2 なので、答えは2です。
        printExample(solution, 13, "13 = 3^2 + 2^2 = 9 + 4");

        // 3個の例: 12 = 2^2 + 2^2 + 2^2 なので、答えは3です。
        printExample(solution, 11, "11 = 3^2 + 1^2 + 1^2 = 9 + 1 + 1");

   
    }

    /** main の出力を統一し、各入力の計算結果を確認しやすくします。 */
    private static void printExample(NumSquares solution, int input, String explanation) {
        System.out.println("入力: " + input);
        System.out.println("説明: " + explanation);
        System.out.println("最小個数: " + solution.numSquares(input));
        System.out.println();
    }
}
