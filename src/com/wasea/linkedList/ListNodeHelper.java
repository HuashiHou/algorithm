package com.wasea.linkedList;

/**
 * 工具类 快速构建链表等功能
 */
public class ListNodeHelper {

    /**
     * 传入数组快速构建链表
     *
     * @param nodes
     * @return
     */
    public static ListNode build(char... nodes) {
        if (nodes.length < 1) {
            return null;
        }
        ListNode head = new ListNode(nodes[0]);
        ListNode p = head;
        for (int i = 1; i < nodes.length; i++) {
            p.next(new ListNode(nodes[i]));
            p = p.next;
        }
        return head;
    }

    public static void main(String[] args) {
        char[] nodes = {'a', 'b', 'c', 'd', 'e', 'f'};
        final ListNode build = build(nodes);
        System.out.println(build);
    }
}
