package com.example.code.generated;

import java.util.*;

public class Problem076 {
    // O（n）就不能是排序 
    // 用HashSet存储所有元素
    // 对于一个最长序列hashSet中一定不包含当前的nums[i] - 1;
    // 判断是否存在nums[i] + 1;
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        int max = 1;
       
        for (int num : nums) {
            if (hs.contains(num - 1)) {
                continue;
            }
            int maxTmp = 1;
            while (hs.contains(num + 1)) {
                num += 1;
                maxTmp++;
            }
            max = Math.max(maxTmp, max);
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println("128. 最长连续序列");
        System.out.println("Solution method is ready.");
    }}
