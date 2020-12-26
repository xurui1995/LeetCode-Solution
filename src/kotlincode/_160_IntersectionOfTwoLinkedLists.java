package kotlincode;

public class _160_IntersectionOfTwoLinkedLists {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int len1 = getLength(headA);
        int len2 = getLength(headB);

        if (len1 > len2) {
            for (int i = 0; i < (len1 - len2); i++) {
                headA = headA.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < (len2 - len1); i++) {
                headB = headB.next;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;

        }

        return null;
    }

    public int getLength(ListNode head) {
        int ans = 0;
        ListNode temp = head;
        while (temp != null) {
            ans++;
            temp = temp.next;
        }

        return ans;
    }
}
