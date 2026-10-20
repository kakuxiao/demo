package com.example.code.generated;

public class RobGame {
    /**
     * 隣り合う家を同時に盗まずに、盗める金額の最大値を求めます。
     *
     * <p>家 i までを調べたとき、最後の家については次の2通りしかありません。</p>
     * <ul>
     *     <li>家 i を盗まない: 家 i - 1 までの最大値をそのまま使う</li>
     *     <li>家 i を盗む: 隣の家 i - 1 は盗めないので、家 i - 2 までの最大値に加える</li>
     * </ul>
     *
     * <p>したがって、動的計画法の式は次のようになります。</p>
     * <p>dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])</p>
     *
     * <p>現在の計算に必要なのは直前2つの状態だけです。dp配列全体を保持せず、
     * 2つの変数だけを使うことで、追加のメモリを O(n) から O(1) に削減します。</p>
     *
     * <p>時間計算量は O(n)、追加の空間計算量は O(1) です。</p>
     *
     * @param nums 各家に置かれた金額。金額は0以上を想定します
     * @return 隣り合う家を選ばずに得られる最大金額
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // previousTwo: 2つ前の家までで得られる最大金額。
        int previousTwo = 0;
        // previousOne: 1つ前の家までで得られる最大金額。
        int previousOne = 0;

        for (int money : nums) {
            // 現在の家を盗まない場合と、盗んで2つ前の結果を足す場合を比較します。
            int current = Math.max(previousOne, previousTwo + money);
            previousTwo = previousOne;
            previousOne = current;
        }
        return previousOne;
    }

    public static void main(String[] args) {
        System.out.println("198. 家を盗む問題");
        System.out.println("隣り合う家を盗まずに、盗める金額の最大値を求めます。\n");

        RobGame solution = new RobGame();
        int[][] examples = {
                {1, 2, 3, 1},
                {2, 7, 9, 3, 1},
                {2, 1, 1, 2},
                {5},
                {}
        };

        for (int[] example : examples) {
            int answer = solution.rob(example);
            System.out.printf("金額 = %s -> 最大金額 = %d%n",
                    java.util.Arrays.toString(example), answer);
        }

        // 例1: [1, 2, 3, 1] では、家1と家3を選ぶと 2 + 1 = 3 です。
        // 例2: [2, 7, 9, 3, 1] では、家0・家2・家4を選ぶと 2 + 9 + 1 = 12 です。
        // 例3: [2, 1, 1, 2] では、家0と家3を選ぶと 2 + 2 = 4 です。
        // 例4: 家が1軒だけなら、その家の金額を選べます。
        // 例5: 家がない場合は、盗める金額がないため 0 を返します。
    }
}
