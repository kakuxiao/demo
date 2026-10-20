package com.example.code.generated;

import java.util.*;

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
public class Problem070 {
    // 创建一个最小堆，存储所有的链表的头结点，每次从链表中取出一个节点，并将这个节点的下一个节点放入最小堆中
    // 这样就可以保证每次取得当前k个节点的最小值
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (ListNode node :lists) {
            if (node != null) { // 需要判断是否为空，否则会出现空指针异常，优先队列不能加入空值
                pq.offer(node);
            }  
        }
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
            if (cur.next != null) {
                pq.offer(cur.next);
            }
        }
        return dummy.next;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
        public ListNode() {}
        public ListNode(int val) { this.val = val; }
        public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }    public static void main(String[] args) {
        System.out.println("23. 合并 K 个升序链表");
        System.out.println("Solution method is ready.");
    }}
