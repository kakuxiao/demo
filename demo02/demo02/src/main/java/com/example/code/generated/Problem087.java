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
public class Problem087 {
    // 用一个列表存储先序遍历的结果，再构建单链表，将列表中的节点的左指针赋值为空，右指针指向列表中的下一个位置
   List<TreeNode> res = new ArrayList<>();
    public void flatten(TreeNode root) {
       if (root == null) {
            return;
       }
       preOrder(root);
       for (int i = 0; i < res.size() - 1; i++) {  // 这里是小于 res.size() - 1,确保不会数组越界
        TreeNode node = res.get(i);
        node.left = null;
        node.right = res.get(i + 1);
       }
    }
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root);
        preOrder(root.left);
        preOrder(root.right);
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
        System.out.println("114. 二叉树展开为链表");
        System.out.println("Solution method is ready.");
    }}
