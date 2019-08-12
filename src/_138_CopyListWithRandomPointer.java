import org.junit.Test;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}


class Solution138 {

    @Test
    public static void main(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
//        node1.next = node2;
//        node1.random = node2;
//        node2.random = node2;
        copyRandomList(node1);
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val, temp.next, null);
            temp.next = newNode;
            temp = newNode.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }

        temp = head;
        Node ans = head.next;
        while (temp != null) {
            Node newNode = temp.next;
            temp.next = temp.next.next;
            newNode.next = temp.next == null ? null : temp.next.next;
            temp = temp.next;
        }

        return ans;
    }
}
