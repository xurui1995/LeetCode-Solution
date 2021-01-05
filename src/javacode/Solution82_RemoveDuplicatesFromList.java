package javacode;

public class Solution82_RemoveDuplicatesFromList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode temp = preHead;
        while (head != null) {
            if (head.next == null || head.next.val != head.val) {
                temp.next = head;
                temp = temp.next;
                head = head.next;
                temp.next = null;
            } else {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
            }
        }
        return preHead.next;
    }
}
