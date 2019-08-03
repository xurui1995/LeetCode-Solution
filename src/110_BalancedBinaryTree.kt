import org.junit.Test

class Solution110 {


    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        node1.left = node2
        node2.left = node3
        node3.left = node4

        println(isBalanced(node1))
    }


    fun isBalanced(root: TreeNode?): Boolean {

        return isBalanceTree(root) != -1
    }

    fun isBalanceTree(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = isBalanceTree(root.left)
        if (left == -1) {
            return -1
        }
        val right = isBalanceTree(root.right)
        if (right == -1) {
            return -1
        }

        if (Math.abs(left - right) <= 1) {
            return Math.max(left + 1, right + 1)
        }

        return -1
    }
}