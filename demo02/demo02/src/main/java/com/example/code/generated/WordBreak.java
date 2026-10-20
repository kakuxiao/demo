package com.example.code.generated;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class WordBreak {
    /**
     * 判断字符串是否可以由字典中的单词拼接而成。
     *
     * <p>例如：s = "applepenapple"，字典为 ["apple", "pen"]，
     * 结果为 true，因为可以拆成 "apple" + "pen" + "apple"。</p>
     *
     * <p>dp[i] 表示 s 的前 i 个字符能否被完整拆分。状态转移为：
     * 如果 dp[start] 为 true，且 s[start..i) 在字典中，那么 dp[i] 为 true。</p>
     *
     * <p>优化点：
     * <ol>
     *     <li>HashSet 将字典查询从线性查找优化为平均 O(1)。</li>
     *     <li>最长单词长度之外的候选长度不可能匹配，直接跳过。</li>
     *     <li>找到一个可行拆分后立即停止当前 end 的搜索。</li>
     * </ol>
    * 时间复杂度约为 O(n * L^2)，其中 n 为字符串长度，L 为字典中最长单词长度；
    * 这是因为 Java 的 substring 和 HashSet 的字符串哈希都需要处理候选字符串；
     * 额外空间复杂度为 O(n + m)，m 为字典单词数量。</p>
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Objects.requireNonNull(s, "s must not be null");
        Objects.requireNonNull(wordDict, "wordDict must not be null");

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // 空字符串可以看作已经完成拆分

        Set<String> dictionary = new HashSet<>();
        int maxWordLength = 0;
        for (String word : wordDict) {
            if (word == null || word.isEmpty()) {
                continue; // 空单词不会产生有效进展，忽略即可
            }
            dictionary.add(word);
            maxWordLength = Math.max(maxWordLength, word.length());
        }

        for (int end = 1; end <= n; end++) {
            // start 只需回看最长单词长度，避免无意义的 substring 和查询。
            int start = Math.max(0, end - maxWordLength);
            for (; start < end; start++) {
                if (dp[start] && dictionary.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break; // 当前 end 已经可以拆分，不必继续寻找其他方案
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
   
        WordBreak solution = new WordBreak();


        //s = "leetcode"
        //dp[0] : ""          → true
        //dp[4] : "leet"      → true
        //dp[8] : "leetcode"  → true
        // 示例 1：可以拆分为 "leet" + "code"。
        System.out.println(solution.wordBreak(
                "leetcode", List.of("leet", "code"))); // true

        // 示例 2：虽然 "cats" 可以匹配，但剩余的 "andog" 无法继续匹配。
        System.out.println(solution.wordBreak(
                "catsandog", List.of("cats", "dog", "sand", "and", "cat"))); // false

        // 示例 3：同一个单词可以重复使用，拆分为 "apple" + "pen" + "apple"。
        System.out.println(solution.wordBreak(
                "applepenapple", List.of("apple", "pen"))); // true
    }
}
