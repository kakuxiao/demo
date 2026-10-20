package com.example.code.generated;

import java.util.*;

public class Problem013 {
    // 背包问题，完全背包
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // dp[i] 代表组成金额为i的最少硬币数
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
            }
        }
        return dp[amount]== amount+1 ? - 1 : dp[amount];

    }
    public static void main(String[] args) {
        System.out.println("322. 零钱兑换");
        System.out.println("Solution method is ready.");
    }}
