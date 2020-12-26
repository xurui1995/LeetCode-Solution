package kotlincode

import org.junit.Test

class Solution101 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2_1 = TreeNode(2)
        val node2_2 = TreeNode(2)
        val node3_1 = TreeNode(3)
        val node3_2 = TreeNode(3)
        val node4_1 = TreeNode(4)
        val node4_2 = TreeNode(4)

        node1.left = node2_1
        node1.right = node2_2

        node2_1.left = node3_1
        node2_1.right = node4_1


        node2_2.left = node4_2
        node2_2.right = node3_2

        println(isSymmetric(node1))
    }

    fun isSymmetric(root: TreeNode?): Boolean {
        mirror(root?.right)
        return isSameTree(root?.left, root?.right)
    }

    fun mirror(root: TreeNode?) {
        if (root != null) {
            val temp = root.left
            root.left = root.right
            root.right = temp
            mirror(root.left)
            mirror(root.right)
        }
    }

    fun isSameTree(root1: TreeNode?, root2: TreeNode?): Boolean {
        return if (root1?.`val` != root2?.`val`) {
            false
        } else {
            if (root1 != null) {
                isSameTree(root1.left, root2?.left) && isSameTree(root1.right, root2?.right)
            } else {
                true
            }
        }
    }
}