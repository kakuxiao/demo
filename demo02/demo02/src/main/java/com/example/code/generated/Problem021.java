package com.example.code.generated;

public class Problem021 {
    //二维动态规划
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for(int len = 2; len <= n; len++) {
            for (int i = 0; i <= n-len; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)){
                    if (len > 2) {
                        dp[i][j] = dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = 1;
                    }
                    
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] != 0){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println("647. 回文子串");
        System.out.println("Solution method is ready.");
    }}
