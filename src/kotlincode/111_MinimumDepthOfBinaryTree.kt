package kotlincode

import org.junit.Test

class Solution111 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        node1.left = node2
        node1.right = node3
        node2.left = node4
        node3.right = node5
        println(minDepth(node1))


    }

    fun minDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null) {
            return 1
        }
        var ans = Int.MAX_VALUE
        if (root.left != null) {
            ans = minDepth(root.left) + 1
        }
        if (root.right != null) {
            ans = Math.min(ans, minDepth(root.right) + 1)
        }
        return ans
    }
}