package com.wasea.linkedList.reverse;

import com.wasea.linkedList.ListNode;

import java.util.List;

/**
 * 链表反转算法
 */
public class LinkedListReverse {
    /**
     * 第一种，递归 在反转当前节点之前先反转后续节点
     * @param head
     * @return
     */
    static ListNode reverse0(ListNode head) {
        if (head ==null || head.next ==null) {
            return head;
        }

        // 递归 从最后一个节点开始反转
        ListNode reHead = reverse0(head.next);
        head.next.next = head;// 自己的下一个的下一个指向自己就是反转过来了
        head.next = null;// 清空自己的next指针 相当于断开链表
        return reHead;
    }

    /**
     * 不使用递归的方法，从前向后进行两两进行交换
     * @param head
     * @return
     */
    static ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = head;// 代表前一个节点
        ListNode cur = head.next;// 代表当前节点
        ListNode temp = null;// 代表下一个节点

        while (cur != null) {
            temp = cur.next;// 暂存下一个节点，后面赋值回来
            cur.next = prev;// 最关键的一句，当前节点next指向前一个节点，即反转了方向

            // 移动指针 整体向后移，当前节点变成前节点，下一节点变成当前节点
            prev = cur;
            cur = temp;
        }

        head.next = null;
        return prev;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode('a');
        head.next(new ListNode('b')).next(new ListNode('d'));
//        System.out.println(reverse0(head));
        System.out.println(reverse1(head));
    }
}
