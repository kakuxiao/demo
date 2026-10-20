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
public class Problem063 {
    //对每一个节点求左子树的最大深度 + 右子树的最大深度
    // 他们之和的最大值即为直径。
    // 直径为所有子节点的最大
    int sum = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return sum;
       
    } 
    public int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        sum = Math.max(sum, leftDepth + rightDepth);
        return Math.max(leftDepth, rightDepth) + 1; //左右节点的最大深度 + 1，因为要包括自身
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
        System.out.println("543. 二叉树的直径");
        System.out.println("Solution method is ready.");
    }}
