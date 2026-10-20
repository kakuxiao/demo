package com.example.code.generated;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 // 两种方法 ： 1. 递归 2.迭代
public class Problem065 {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
       res = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode cur = root;
       while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;  // 左
            }
            cur = stack.pop();
            res.add(cur.val); // 中
            cur = cur.right; // 右
       }
       return res;
    }
   
      
    

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }    public static void main(String[] args) {
        System.out.println("94. 二叉树的中序遍历");
        System.out.println("Solution method is ready.");
    }}
