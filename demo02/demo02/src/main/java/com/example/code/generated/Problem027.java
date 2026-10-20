package com.example.code.generated;

import java.util.*;

public class Problem027 {
    // 回溯，全排列
    // stringBuffer的append方法和deleteCharAt()方法
    // 有效的括号组合，对于任意括号左边的左括号的数量大于等于右括号的数量
    // 空间复杂度：O(n)
    List<String> res;
    int left, right;
    int count = 0;
    StringBuffer sb = new StringBuffer(); 
    public List<String> generateParenthesis(int n) {
        left = 0;
        right = 0;
        count = n;
        res = new ArrayList<>();
        backTracking();
        return res;
    }

    public void backTracking() {
        if (right == count) {
            res.add(sb.toString());
        }
        if (left < count) { // append左括号
            sb.append('(');
            left++;
            backTracking();
            sb.deleteCharAt(sb.length() - 1); 
            left--;
        }
        if (right < left) { // append右括号，右括号的数量需要小于左括号的数量
            sb.append(')');
            right++;
            backTracking();
            sb.deleteCharAt(sb.length() - 1);
            right--;
        }
    }
    public static void main(String[] args) {
        System.out.println("22. 括号生成");
        System.out.println("Solution method is ready.");
    }}
