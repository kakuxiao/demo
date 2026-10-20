package com.example.code.generated;

import java.util.Arrays;

public class ProductExceptSelf {
    /**
     * 各要素を除いた配列の積を返します。
     * 238. 除了自身以外数组的乘积
     * <p>例: [1, 2, 3, 4] -> [24, 12, 8, 6]</p>
     *
     * <p>割り算は使わず、時間計算量 O(n)、追加領域 O(1) で解きます。
     * 返却用の配列は必要な領域なので、追加領域には数えません。</p>
     *
     * @param nums 入力配列
     * @return nums[i] 以外の要素をすべて掛け合わせた配列
     */
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length];

        // 1回目の走査: result[i] に、iより左側にある要素の積を保存します。
        // 左端には左側の要素がないため、積の単位元である1から始めます。
        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = leftProduct;
            leftProduct *= nums[i];
        }

        // 2回目の走査: 右側の積を掛けると、nums[i] 自身を除いた積になります。
        // 右端には右側の要素がないため、rightProduct も1から始めます。
        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductExceptSelf solution = new ProductExceptSelf();

        System.out.println("238. 自分以外の配列要素の積");
        System.out.println("割り算を使わず、左側の積と右側の積を組み合わせます。\n");

        // 基本例: [1, 2, 3, 4]
        int[] basicCase = {1, 2, 3, 4};
        System.out.println("基本例");
        System.out.println("入力 : " + Arrays.toString(basicCase));
        System.out.println("出力 : " + Arrays.toString(solution.productExceptSelf(basicCase)));
        System.out.println("計算例: [2*3*4, 1*3*4, 1*2*4, 1*2*3] = [24, 12, 8, 6]\n");

        // ゼロが1個だけある例: ゼロ以外の位置はすべて0になります。
        int[] oneZeroCase = {2, 0, 4, 5};
        System.out.println("ゼロが1個ある例");
        System.out.println("入力 : " + Arrays.toString(oneZeroCase));
        System.out.println("出力 : " + Arrays.toString(solution.productExceptSelf(oneZeroCase)));
        System.out.println("ポイント: ゼロの位置だけ、ゼロ以外の要素の積になります。\n");

        // 負数を含む例: 掛け算なので、符号も正しく反映されます。
        int[] negativeCase = {-1, 2, -3};
        System.out.println("負数を含む例");
        System.out.println("入力 : " + Arrays.toString(negativeCase));
        System.out.println("出力 : " + Arrays.toString(solution.productExceptSelf(negativeCase)));
        System.out.println("計算例: [2*(-3), (-1)*(-3), (-1)*2] = [-6, 3, -2]\n");

        // 空配列は、要素がないため空配列を返します。
        int[] emptyCase = {};
        System.out.println("空配列の例");
        System.out.println("入力 : " + Arrays.toString(emptyCase));
        System.out.println("出力 : " + Arrays.toString(solution.productExceptSelf(emptyCase)));
    }
}
