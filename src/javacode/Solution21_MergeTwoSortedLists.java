package javacode;

import org.junit.Test;

public class Solution21_MergeTwoSortedLists {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode fakeHead = new ListNode();
        ListNode temp = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val == l2.val) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;

                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            } else {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }
        return fakeHead.next;
    }
}
