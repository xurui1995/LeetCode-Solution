import org.junit.Test;

class Solution141 {

    @Test
    public static void main(String[] ags) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node1);

        System.out.println(new Solution141().hasCycle(node1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.getNext() == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null ) {

            fast = fast.getNext();
            if (fast != null) {
                fast = fast.getNext();
            }

            slow = slow.getNext();

            if ( slow == fast) {
                return true;
            }
        }

        return false;
    }
}
