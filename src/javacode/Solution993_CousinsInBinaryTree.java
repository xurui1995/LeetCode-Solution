package javacode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution993_CousinsInBinaryTree {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode end = root;
        TreeNode last = root;
        int target = -1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            int left = -1000;

            if (temp.left != null) {
                left = temp.left.val;
                queue.offer(temp.left);
                last = temp.left;
            }
            int right = -1000;
            if (temp.right != null) {
                right = temp.right.val;
                queue.offer(temp.right);
                last = temp.right;
            }

            if (target != -1) {
                if (left == target || right == target) {
                    return true;
                }
            } else {
                if ((left == x && right == y) || (left == y && right == x)) {
                    return false;
                }
                if (left == x || left == y) {
                    target = x + y - left;
                } else if (right == x || right == y) {
                    target = x + y - right;
                }
            }

            if (temp == end) {
                end = last;
                if (target != -1) {
                    return false;
                }
            }
        }
        return false;
    }
}
