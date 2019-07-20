package com.wasea.linkedList.palindrome;

/**
 * practice
 */
public class PalindromeLinkedListPractice {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    static boolean isPalindrome(ListNode head) {
        if(head ==null || head.next ==null) {
            return true;
        }

        ListNode prev = null;
        ListNode fast = head;
        ListNode slow = head;

        while (fast!=null && fast.next!=null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow!=null && prev!=null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }


        return true;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode('a');
        ListNode b = a.next = new ListNode('b');
        ListNode c = b.next = new ListNode('c');
        c.next = new ListNode('a');
        System.out.println(isPalindrome(a));
    }
}

