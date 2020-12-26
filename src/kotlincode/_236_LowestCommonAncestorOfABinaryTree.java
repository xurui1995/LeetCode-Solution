package kotlincode;

import org.junit.Test;

import java.util.LinkedList;


class Solution236 {

    @Test
    public static void main(String[] args) {
        Solution236 s = new Solution236();
        s.test();
    }

    private void test() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.right = node4;

        System.out.println(lowestCommonAncestor(node1, node4, node3).val);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        out1:
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                if (root == p || root == q) {
                    // find one
                    break out1;
                }
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop().right;
            }
        }

        TreeNode node = stack.pop();
        TreeNode target;
        if (node == p) {
            target = q;
        } else {
            target = p;
        }

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (findNode(temp.right, target)) {
                return temp;
            }
        }
        return node;
    }

    private boolean findNode(TreeNode root, TreeNode target) {
        if (root == target) {
            return true;
        }

        if (root != null) {
            return findNode(root.left, target) || findNode(root.right, target);
        }
        return false;
    }
}
