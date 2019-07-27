package com.wasea.linkedList.middle;

import com.wasea.linkedList.ListNode;
import com.wasea.linkedList.ListNodeHelper;

/**
 * 查找链表的中间节点
 */
public class FinedMiddleNode {

    /**
     * 链表节点个数为奇数时返回中间节点
     * 为偶数时返回靠右的中间节点
     * @param head
     * @return
     */
    public static ListNode findMiddleNode(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pSlow = head, pFast = head.next;
        while (pFast != null && pFast.next != null) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }

        // pFast == null时为链表个数奇数个，否则为偶数个（取决于快指针最开始从哪里起始）
        return pFast==null? pSlow:pSlow.next;
    }

    public static void main(String[] args) {
        final ListNode nodes = ListNodeHelper.build('a', 'b', 'c', 'd', 'e');
        final ListNode middleNode = findMiddleNode(nodes);
        System.out.println(middleNode.val);
    }
}
