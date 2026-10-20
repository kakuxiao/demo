package com.example.code.generated;

public class Problem019 {
   public int maxSubArray(int[] nums) {
    // dp数组代表以nums[i]结尾的的最大子数组和，i代表索引
    // if (dp[i-1] < 0) dp[i] = nums[i];
    // else dp[i] = dp[i-1] + nums[i];
    // 找到dp数组的最大值
    
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            max = Math.max(dp[i],max);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println("53. 最大子数组和");
        System.out.println("Solution method is ready.");
    }}
