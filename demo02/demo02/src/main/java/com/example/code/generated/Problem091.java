package com.example.code.generated;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Problem091 {
    // 计算两个链表的长度，让长的链表先走Math.abs(lenA - lenB)
    // 之后两个链表的指针每次都指向下一个位置
    // return 指针指向同一个位置的节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //链表相交节点代表值相等
        int lenA = 1, lenB = 1;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        int sub = lenA > lenB ? lenA - lenB : lenB - lenA;
        if (lenA > lenB) {
            int count = 0;
            while (count < sub) {
                curA = curA.next;
                count++;
            }
            while (curA != curB && curA != null && curB != null) {
                curA = curA.next;
                curB = curB.next; 
            }
            return curA;
        } else {
            int count = 0;
            while (count < sub) {
                curB= curB.next;
                count++;
            }
            while (curA != curB && curA != null && curB != null) {
                curA = curA.next;
                curB = curB.next; 
            }
            return curB;
        }
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    public static void main(String[] args) {
        System.out.println("160. 相交链表");
        System.out.println("Solution method is ready.");
    }}
