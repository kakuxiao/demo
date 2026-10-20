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
public class Problem093 {
    // 用一个变量记录进位
    // 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       ListNode dummyRes = new ListNode();
       ListNode cur = dummyRes;
       int yushu = 0, sum = 0;
       while (l1 != null || l2 != null) {
         cur.next = new ListNode();
            int var1 = (l1 == null) ? 0 : l1.val;
            int var2 = (l2 == null) ? 0 : l2.val;
            sum = var1 + var2 + yushu;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            yushu = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            
       }
       if (yushu != 0) {
            cur.next = new ListNode(yushu);
       }
       return dummyRes.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    public static void main(String[] args) {
        System.out.println("2. 两数相加");
        System.out.println("Solution method is ready.");
    }}
