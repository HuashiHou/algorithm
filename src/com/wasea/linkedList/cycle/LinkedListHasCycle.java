package com.wasea.linkedList.cycle;

import com.sun.tools.javac.util.Assert;
import com.wasea.linkedList.ListNode;

import java.util.HashMap;
import java.util.List;

/**
 * 判断单链表是否有环
 * 以及非环部分的长度、环的起始点
 */
public class LinkedListHasCycle {

    /**
     * 使用快慢指针，
     * 快指针每次走两步，慢指针每次走一步
     * 如果链表中有环，那两个指针必定有相遇的时候
     * @param head
     * @return
     */
    public static boolean doesLinkedListHasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode pFast = head.next.next,pSlow = head.next;

        while (pFast.next != null && pSlow.next != null) {
            if (pFast == pSlow) {
                return true;
            }
            pFast = pFast.next.next;
            pSlow = pSlow.next;
        }
        return false;
    }

    /**
     * 使用Map将每一个走过的节点存进去
     * 在存之前get一下，如果get有值，说明之前存过，即证明有环
     * @param head
     * @return
     */
    public static boolean doesLinkedListHasCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        final HashMap<ListNode, Object> map = new HashMap<>();
        ListNode p = head;

        while (p.next != null) {
            if (map.containsKey(p)) {
                return true;
            }
            map.put(p, null);
            p = p.next;
        }

        return false;
    }

    /**
     * 查找链表环的起点
     * @param head
     * @return null代表没有环
     */
    public static ListNode findCycleHead(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode pFast = head, pSlow = head;
        // 循环直到快慢指针相遇
        while (true) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == null) {
                return null;
            }

            if(pFast == pSlow) {
                break;
            }
        }

        // 让快指针等于头节点，然后各自以1 的步长继续前进，直到再次相遇
        // 相遇点即为环的起始点
        pFast = head;
        // 可以顺便计算出非环部分的长度
        int i = 0;
        while (true) {
            pFast = pFast.next;
            pSlow = pSlow.next;
            i++;
            if (pFast == pSlow) {
                System.out.println("length of not cycle in this LinkedList: " + i);
                return pFast;
            }
        }
    }

    /**
     * 计算环的长度，没有环就返回0
     * @param head
     * @return
     */
    public static int calculateCycleLength(ListNode head) {
        if (head == null || head.next == null) {
            return 0;
        }
        ListNode pFast = head, pSlow = head;
        // 直到相遇
        while (true) {
            pFast = pFast.next.next;
            pSlow = pSlow.next;
            if (pFast == null) {
                return 0;
            }
            if (pFast == pSlow) {
                break;
            }
        }

        // pFast停下，pSlow继续走，直到再次相遇 pSlow走过的长度即为环的长度
        int cycleLength = 0;
        while (true) {
            pSlow = pSlow.next;
            cycleLength++;
            if (pSlow == pFast) {
                break;
            }
        }

        return cycleLength;
    }

    public static void main(String[] args) {
        //构造一个有环的链表
        final ListNode a = new ListNode('a');
        //环的起始节点
        final ListNode c = new ListNode('c');

        a.next(new ListNode('b')).next(c).next(new ListNode('d')).next(new ListNode('e')).next(new ListNode('f')).next(c);

//        System.out.println(doesLinkedListHasCycle(a));
//        System.out.println(doesLinkedListHasCycle1(a));

//        final ListNode cycleHead = Assert.checkNonNull(findCycleHead(a));
//        System.out.println(cycleHead.val);

        System.out.println(calculateCycleLength(a));
    }

}
