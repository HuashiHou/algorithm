package com.wasea.linkedList.merge;

import com.wasea.linkedList.ListNode;
import com.wasea.linkedList.ListNodeHelper;

/**
 * 合并两个有序的链表
 * 如果是两个无序的链表，那么对他们各自排序再合并就好了
 */
public class MergeTwoLinkedList {

    /**
     * 使用递归从开始比较两个链表，放入新的链表
     * @param h1
     * @param h2
     * @return
     */
    public static ListNode mergeTwoLinkedList(ListNode h1, ListNode h2) {
        if (h1 == null) {
            return h2;
        }
        if (h2 == null) {
            return h1;
        }
        ListNode head = null;
        if (h1.val <= h2.val) {
            head = h1;
            head.next(mergeTwoLinkedList(h1.next, h2));
        }else {
            head = h2;
            head.next(mergeTwoLinkedList(h1, h2.next));
        }
        return head;
    }

    public static void main(String[] args) {
        final ListNode a = ListNodeHelper.build('a', 'c', 'e');

        final ListNode b = ListNodeHelper.build('b', 'd', 'f');

        System.out.println(mergeTwoLinkedList(a, b));
    }
}
