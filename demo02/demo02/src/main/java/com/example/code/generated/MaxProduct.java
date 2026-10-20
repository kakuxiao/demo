package com.example.code.generated;

public class MaxProduct {
    /**
     * 連続する部分配列の中から、積が最大になる値を求めます。
     *
     * <p>nums[i] を最後の要素とする部分配列について、最大値だけでなく
     * 最小値も保持する必要があります。負の数を掛けると、最小値が次の
     * 最大値になる可能性があるためです。例えば [-2, 3, -4] では、
     * 途中の最小積 -6 に -4 を掛けることで最大積 24 が得られます。</p>
     *
     * <p>各要素を処理するときの状態遷移は次のとおりです。</p>
     * <ul>
     *     <li>現在の最大積 = max(現在の値, 現在の値 * 直前の最大積, 現在の値 * 直前の最小積)</li>
     *     <li>現在の最小積 = min(現在の値, 現在の値 * 直前の最大積, 現在の値 * 直前の最小積)</li>
     * </ul>
     *
     * <p>現在の状態は直前の状態だけから計算できます。そのため、配列全体を
     * 保存する動的計画法ではなく、最大積と最小積の2つの変数だけで計算します。</p>
     *
     * <p>時間計算量は O(n)、追加の空間計算量は O(1) です。</p>
     *
     * @param nums 入力配列。少なくとも1つの要素が必要です
     * @return 連続する部分配列の最大積
     * @throws IllegalArgumentException nums が null または空の場合
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("nums must contain at least one element");
        }

        int currentMax = nums[0];
        int currentMin = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int value = nums[i];
            int previousMax = currentMax;
            int previousMin = currentMin;

            // 現在の値から新しく始める場合と、直前の部分配列に追加する場合を比較します。
            // previousMax と previousMin は、currentMax を更新する前の値でなければなりません。
            currentMax = Math.max(value, Math.max(value * previousMax, value * previousMin));
            currentMin = Math.min(value, Math.min(value * previousMax, value * previousMin));
            result = Math.max(result, currentMax);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println("152. 最大積を持つ連続部分配列");

        MaxProduct solution = new MaxProduct();
        int[][] examples = {
                {2, 3, -2, 4},
                {-2, 3, -4},
                {-2, 0, -1},
                {-2, 3, -4, -1}
        };

        for (int[] example : examples) {
            int answer = solution.maxProduct(example);
            System.out.printf("nums = %s, 最大積 = %d%n",
                    java.util.Arrays.toString(example), answer);
        }

        // 実行結果の例：
        // [2, 3, -2, 4] -> 6。最大となる部分配列は [2, 3] です。
        // [-2, 3, -4] -> 24。配列全体の積 (-2) * 3 * (-4) が最大です。
        // [-2, 0, -1] -> 0。0 によって前後の連続部分配列が分かれます。
        // [-2, 3, -4, -1] -> 24。負の最小積が負数を掛けた後に最大積になります。
    }
}
