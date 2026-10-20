package com.example.code.generated;

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
public class Problem055 {
    // 1. 层序遍历，用一个变量记录总共有多少层
    // 2.递归
    public int maxDepth(TreeNode root) {
       if (root == null) {
        return 0;
       }
       int leftDepth = maxDepth(root.left);
       int rightDepth = maxDepth(root.right);
       return Math.max(leftDepth,rightDepth) + 1;
        // if (root == null) {
        //     return 0;
        // }
        // Queue<TreeNode> que = new LinkedList<>();
        // que.offer(root);
        // int count = 0;
        // while (!que.isEmpty()) {
        //     int len = que.size();
        //     count++;
        //     while (len > 0) {
        //         TreeNode tmp = que.poll();
        //         if (tmp.left != null) {
        //             que.offer(tmp.left);
        //         }
        //         if (tmp.right != null) {
        //             que.offer(tmp.right);
        //         }
        //         len--;
        //     }
        // }
        // return count;
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
        System.out.println("104. 二叉树的最大深度");
        System.out.println("Solution method is ready.");
    }}
