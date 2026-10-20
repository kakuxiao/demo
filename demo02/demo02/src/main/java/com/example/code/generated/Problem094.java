package com.example.code.generated;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Problem094 {
    // 链表的题往往使用虚拟头结点的方法 ListNode dummy 让虚拟头结点指向head，避免对head特判
    // 链表的题删除链表、翻转节点、添加节点都要用双指针
    public ListNode reverseList(ListNode head) {
       ListNode pre = null;
       ListNode cur = head;
       while (cur != null) {
        ListNode tmp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = tmp;
       }
       return pre;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    public static void main(String[] args) {
        System.out.println("206. 反转链表");
        System.out.println("Solution method is ready.");
    }}
