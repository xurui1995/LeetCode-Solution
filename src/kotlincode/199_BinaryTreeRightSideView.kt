package kotlincode

import org.junit.Test
import java.util.*

class Solution199 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        node1.left = node2
        node1.right = node3
        node2.right = node5
        node3.right = node4

        println(rightSideView(node1))
    }

    fun rightSideView(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root != null) {
            val queue = LinkedList<TreeNode>()
            var nLast = root
            var last = root
            queue.offer(root)

            while (queue.isNotEmpty()) {
                val node = queue.poll()
                if (node.left != null) {
                    last = node.left
                    queue.offer(last)
                }
                if (node.right != null) {
                    last = node.right
                    queue.offer(last)
                }

                if (node == nLast) {
                    ans.add(node.`val`)
                    nLast = last
                }

            }
        }
        return ans
    }
}