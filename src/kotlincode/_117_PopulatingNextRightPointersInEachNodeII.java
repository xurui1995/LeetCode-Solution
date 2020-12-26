package kotlincode;

class Solution117 {

    class Node {
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
        if (root == null) {
            return null;
        }
        if (getLastChild(root) == null) {
            return root;
        } else {
            if (haveTwoChild(root)) {
                root.left.next = root.right;
            }
            Node temp = root.next;
            while (temp != null) {
                if (getLastChild(temp) != null) {
                    break;
                }
                temp = temp.next;
            }

            if (temp != null) {
                getLastChild(root).next = temp.left == null ? temp.right : temp.left;
            }
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getLastChild(Node root) {
        return root.right == null ? root.left : root.right;
    }

    private boolean haveTwoChild(Node root) {
        return root.left != null && root.right != null;
    }
}
