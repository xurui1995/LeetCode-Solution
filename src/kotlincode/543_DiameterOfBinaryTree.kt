package kotlincode

import org.junit.Test

class Solution543 {

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
        node2.right = node5

        print(diameterOfBinaryTree(node1))
    }

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        return diameterOfBinaryTreeByStep(root)[0]
    }


    fun diameterOfBinaryTreeByStep(root: TreeNode?): IntArray {
        if (root == null) {
            return intArrayOf(0, 0)
        } else {
            val left = diameterOfBinaryTreeByStep(root.left)
            val right = diameterOfBinaryTreeByStep(root.right)

            val array = intArrayOf(0, 0)
            if (root.left != null) {
                left[1]++
            }
            if (root.right != null) {
                right[1]++
            }

            array[1] = Math.max(left[1], right[1])
            array[0] = Math.max(Math.max(left[0], right[0]), left[1] + right[1])
            return array
        }
    }
}