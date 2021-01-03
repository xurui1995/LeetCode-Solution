package javacode;

import org.junit.Test;

class ReturnType {
    public int passMax;
    public int max;

    public ReturnType(int passMax, int max) {
        this.passMax = passMax;
        this.max = max;
    }
}

public class Solution124_BinaryTreeMaximumPathSum {

    @Test
    public void test() {
        TreeNode node1 = new TreeNode(-10);
        TreeNode node2 = new TreeNode(-9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

//        node1.left = node2;
//        node1.right = node3;
//        node3.left = node4;
//        node3.right = node5;
        System.out.println(maxPathSum(node1));

    }

    public int maxPathSum(TreeNode root) {
        ReturnType returnType = dfs(root);
        return returnType.max;
    }

    public ReturnType dfs(TreeNode node) {
        if (node == null) {
            return new ReturnType(0, Integer.MIN_VALUE);
        }


        ReturnType left = dfs(node.left);
        ReturnType right = dfs(node.right);

        int passMax = Math.max(node.val, Math.max(left.passMax + node.val, node.val + right.passMax));

        int max = Math.max(Math.max(left.max, right.max), Math.max(passMax, left.passMax + node.val + right.passMax));
        return new ReturnType(passMax, max);
    }
}
