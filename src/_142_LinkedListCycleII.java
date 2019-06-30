import org.junit.Test;

class Solution142 {


    @Test
    public static void main(String[] ags) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node2);

        System.out.println(new Solution142().detectCycle(node1).getVal());
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return null;
        }

        if (head.getNext() == head) {
            return head;
        }

        ListNode slow = head.getNext();
        ListNode fast = head.getNext().getNext();

        while (slow != fast && fast != null) {
            slow = slow.getNext();
            fast = fast.getNext();
            if (fast != null) {
                fast = fast.getNext();
            }
        }

        if (fast != null) {
            ListNode startNode = head;
            while (slow != startNode) {
                slow = slow.getNext();
                startNode = startNode.getNext();
            }
            return startNode;
        }

        return  null;
    }
}
