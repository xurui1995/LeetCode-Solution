class Solution116 {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root != null) {
            connectStep(root, root, root);
        }
        return root;
    }

    private boolean isLeaf(Node root) {
        return (root.left == null && root.right == null);
    }

    private void connectStep(Node root, Node head, Node temp) {
        if (isLeaf(root)) {
            return;
        }
        if (temp == head) {
            head = root.left;
            temp = root.right;
            root.left.next = root.right;
        } else {
            root.left.next = root.right;
            temp.next = root.left;
            temp = root.right;
        }
        if (root.next == null) {
            temp = head;
            connectStep(head, head, temp);
        } else {
            connectStep(root.next, head, temp);
        }
    }
}
