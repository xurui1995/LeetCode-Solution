package kotlincode;

class Solution235 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = p.val < q.val?p.val:q.val;
        int max = p.val > q.val?p.val:q.val;
        if (root.val > max) {
            return lowestCommonAncestor(root.left, p,q);
        }
        if (root.val < min) {
            return lowestCommonAncestor(root.right, p,q);
        }
        return root;
    }
}
