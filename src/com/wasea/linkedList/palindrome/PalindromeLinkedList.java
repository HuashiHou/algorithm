package com.wasea.linkedList.palindrome;

import com.wasea.linkedList.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 */
public class PalindromeLinkedList {

    // solution
    // 思路：使用快慢两个指针找到链表中点，
    //      慢指针每次前进一步，快指针每次前进两步。
    //      在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。
    //      最后比较中点两侧的链表是否相等。
    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            // 每次跳两个 变相控制了循环的次数，相当于除2
            fast = fast.next.next;
            // 临时变量 暂存
            ListNode next = slow.next;
            // 一开始prev为空时：slow变成了头节点；到后面就是把本来在prev的元素变成它的next
            slow.next = prev;
            prev = slow;

            slow = next;
        }
        // 循环结束 prev就是链表前半部分反序后的链表，slow就是原链表的后半部分

        // 链表节点为偶数时刚好除尽，为奇数时这里的fast就是最后一个节点
        // 节点个数为奇数时则不用比较中间节点 所以这里.next跳过了中间节点
        if (fast != null) {
            slow = slow.next;
        }

        // 依次比较，如果有不同直接返回false
        while (slow != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode('a');
        head.next(new ListNode('b')).next(new ListNode('a'));
        System.out.println(head);
        System.out.println(isPalindrome(head));
    }
}




