package kotlincode

import org.junit.Test
import java.util.*

class Solution144 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        node1.right = node2
        node2.left = node3

        println(preorderTraversal(node1))
    }

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                ans.add(node.`val`)
                node = node.left
            }
            if (stack.isNotEmpty()) {
                node = stack.pop().right
            }
        }
        return ans
    }
}