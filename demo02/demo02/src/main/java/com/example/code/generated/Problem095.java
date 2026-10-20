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
public class Problem095 {
     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //创建一个新的链表，比较两个链表将小的值加入这个链表；
        //创建一个新的链表，比较两个链表将小的值加入这个链表；
        // 类似于归并排序的合并过程
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = (list1 == null) ? list2 : list1;
        return dummy.next;    
   
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    public static void main(String[] args) {
        System.out.println("21. 合并两个有序链表");
        System.out.println("Solution method is ready.");
    }}
