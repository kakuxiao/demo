package com.example.code.generated;

/*
計算量O(mn)。
*/
public class RegexMatch {

    // dp[i][j] 表示 s 的前 i 个字符是否能与 p 的前 j 个字符完全匹配。
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pattern = p.charAt(j - 1);
                if (pattern == '.' || pattern == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pattern == '*' && j >= 2) {
                    char previous = p.charAt(j - 2);
                    boolean matchesPrevious = previous == '.' || previous == s.charAt(i - 1);
                    dp[i][j] = dp[i][j - 2] || (matchesPrevious && dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        RegexMatch solution = new RegexMatch();

        System.out.println(solution.isMatch("a", "a"));

        System.out.println(solution.isMatch("aab", "c*a*b"));
    }
}
