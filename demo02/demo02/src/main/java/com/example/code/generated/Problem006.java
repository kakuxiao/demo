package com.example.code.generated;

public class Problem006 {
    /**
    * 文字 '1' だけで構成された最大正方形の面積を返す。
     *
    * <p>dp[j] は、現在の行を処理した後の、j 列を右端とする最大正方形の一辺の長さを表す。
    * matrix[i][j] が '1' のとき、正方形の一辺の長さは上・左・左上の値で決まる。
     *
     * <pre>
    * dp[j] = min(上, 左, 左上) + 1
     * </pre>
     *
    * <p>dp[j] を更新する前は上の値を保持している。
    * 更新前に保存した prevDiagonal が左上の値となるため、2次元 DP 配列は不要になる。</p>
     *
    * <p>時間計算量は O(m * n)、空間計算量は O(n)。m は行数、n は列数を表す。</p>
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;
        int[] dp = new int[columns + 1];
        int maxSide = 0;

        for (int row = 0; row < rows; row++) {
            int prevDiagonal = 0;
            for (int column = 1; column <= columns; column++) {
                int upper = dp[column]; // 更新前の dp[column] は上の値
                if (matrix[row][column - 1] == '1') {
                    dp[column] = Math.min(
                            Math.min(dp[column], dp[column - 1]), prevDiagonal) + 1;
                    maxSide = Math.max(maxSide, dp[column]);
                } else {
                    dp[column] = 0; // 現在のマスが 0 なら、正方形はここを通れない
                }
                prevDiagonal = upper; // 次の列では左上の値として使う
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        System.out.println("221. 最大正方形");

        Problem006 solution = new Problem006();

        // 例1: 最大の正方形は一辺 2、面積は 2 * 2 = 4。
        char[][] example1 = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println("例1の結果: " + solution.maximalSquare(example1)); // 4

        // 例2: 1 が1つだけなので、最大の正方形の一辺は 1、面積は 1。
        char[][] example2 = {
                {'0', '1'},
                {'1', '0'}
        };
        System.out.println("例2の結果: " + solution.maximalSquare(example2)); // 1

        // 例3: 1 がないため正方形は作れず、面積は 0。
        char[][] example3 = {
                {'0', '0'},
                {'0', '0'}
        };
        System.out.println("例3の結果: " + solution.maximalSquare(example3)); // 0

        // 例4: 空の行列も安全に処理でき、matrix[0] にアクセスして例外にならない。
        System.out.println("例4の結果: " + solution.maximalSquare(new char[0][0])); // 0
    }
}
