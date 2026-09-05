package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Test004
 */
class Test004 {
    // ローカル実行用の main メソッド
    public static void main(String[] args) {
        Test004 solution = new Test004();
        
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = solution.twoSum(nums, target);
        
        // 結果を出力 (出力例: [0, 1])
        System.out.println(Arrays.toString(result));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution found");
    }
}