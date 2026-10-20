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
public class Problem062 {
    // 解决方案使用了一个递归的方法。算法的关键步骤如下:
    // 如果当前节点为空,则返回 null。
    // 首先递归处理右子树,因为我们需要先处理比当前节点大的节点。
    // 处理完右子树后,累加当前节点的值到 sum 变量中,并将当前节点的值更新为 sum。
    // 最后递归处理左子树
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
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
        System.out.println("538. 把二叉搜索树转换为累加树");
        System.out.println("Solution method is ready.");
    }}
