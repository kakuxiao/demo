package com.example;

/**
 * Test005
 */
class Test005 {
    // ローカル実行用の main メソッド
    public static void main(String[] args) {
        Test005 solution = new Test005();
        
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 5};
        
        double result = solution.findMedianSortedArrays(nums1, nums2);
        
        // 結果を出力 (出力例: 2.0)
        System.out.println(result);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // nums1 が短い方の配列になるよう保証し、短い方の配列で二分探索を行うことで時間計算量を最適化する
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;

            // partitionX が 0 の場合、左側に要素がないため -infinity (Integer.MIN_VALUE) とする
            // partitionX が m の場合、右側に要素がないため +infinity (Integer.MAX_VALUE) とする
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            // 正しい切断位置（分割線）が見つかったかチェックする
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // 全体の要素数が偶数の場合
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    // 全体の要素数が奇数の場合
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
                
            } else if (maxLeftX > minRightY) {
                // nums1 の左側が大きすぎるため、partitionX を左へ移動させる
                high = partitionX - 1;
            } else {
                // nums1 の右側が小さすぎる（＝maxLeftY > minRightX）ため、partitionX を右へ移動させる
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid.");
    }
}