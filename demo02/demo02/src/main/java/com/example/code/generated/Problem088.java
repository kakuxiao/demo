package com.example.code.generated;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 //环形链表，快慢指针
public class Problem088 {
    // Floyd判圈法
    public boolean hasCycle(ListNode head) {
       if (head == null || head.next == null) {
        return false;
       }
       ListNode fast = head;
       ListNode slow = head;
       while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
       }
       return false;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    public static void main(String[] args) {
        System.out.println("141. 环形链表");
        System.out.println("Solution method is ready.");
    }}
