class Solution112 {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        return hasPathSum(root, 0, sum)
    }

    fun hasPathSum(root: TreeNode?, sum: Int, target: Int): Boolean {
        if (root == null) {
            return false
        }

        if (root.left == null && root.right == null) {
            return sum + root.`val` == target
        }

        var ans = false
        if (root.left != null) {
            ans = hasPathSum(root.left, sum + root.`val`, target)
        }
        if (!ans && root.right != null) {
            ans = hasPathSum(root.right, sum + root.`val`, target)
        }

        return ans
    }
}