package kotlincode

import org.junit.Test

class Solution222 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)

        node1.left = node2
        node1.right = node3
        node2.left = node4
        node2.right = node5
        node3.left = node6

        println(countNodes(node1))
    }

    fun countNodes(root: TreeNode?): Int {
        return countNodes(root, 1)
    }

    fun countNodes(root: TreeNode?, number: Int): Int {
        if (root == null) {
            return 0
        }
        if (root.left == null && root.right == null) {
            return number
        }

        if (root.right == null) {
            return number shl 1
        }

        return Math.max(countNodes(root.left, number shl 1), countNodes(root.right, (number shl 1) or 1))
    }
}