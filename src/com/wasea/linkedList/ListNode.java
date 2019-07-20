package com.wasea.linkedList;

public class ListNode {
    public char val;
    public ListNode next;

    public ListNode(char val) {
        this.val = val;
    }

    // builder mode
    public ListNode next(ListNode next) {
        this.next = next;
        return next;
    }

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}