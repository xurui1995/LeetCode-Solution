package kotlincode

import org.junit.Test
import java.util.*

class Solution145 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        node1.right = node2
        node2.left = node3

        println(postorderTraversal(node1))
    }


    fun postorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        val flagStack = LinkedList<Boolean>()

        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                flagStack.push(false)
                node = node.left
            }

            if (stack.isNotEmpty()) {
                val visited = flagStack.pop()
                if (visited) {
                    ans.add(stack.pop().`val`)
                } else {
                    flagStack.push(true)
                    node = stack.peek().right
                }
            }
        }

        return ans
    }
}