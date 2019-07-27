package com.wasea.linkedList.delete;

import com.wasea.linkedList.ListNode;
import com.wasea.linkedList.ListNodeHelper;

/**
 * 删除链表的倒数第n个节点
 */
public class DeleteNodeFromBack {

    /**
     * 使用快慢指针，快指针比慢指针多n
     * 所以当快指针抵达尾部，满指针的next就是准备删除的节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode deleteNodeFromBack(ListNode head, int n) {
        // 空链表
        if (head == null) {
            return null;
        }
        // 只有一个节点
//        if (head.next == null) {
//            if (n == 1) {
//                return null;
//            }
//        }

        ListNode pSlow = head;
        ListNode pFast = head;

        for (int i = 0; i < n; i++) {
            pFast = pFast.next;
        }

        while (pFast.next != null) {
            pFast = pFast.next;
            pSlow = pSlow.next;
        }

        // 删除节点
        pSlow.next = pSlow.next.next;
//        System.out.println(pSlow);
        return head;
    }

    public static void main(String[] args) {
        final ListNode nodes = ListNodeHelper.build('a', 'b', 'c', 'd', 'e');
        final ListNode listNode = deleteNodeFromBack(nodes, 4);
        System.out.println(listNode);
    }
}
