package kotlincode

import org.junit.Test
import java.util.*

class Solution102 {

    @Test
    fun test() {
        val node3 = TreeNode(3)
        val node1 = TreeNode(1)
        val node5 = TreeNode(5)
        val node0 = TreeNode(0)
        val node2 = TreeNode(2)
        val node4 = TreeNode(4)
        val node6 = TreeNode(6)

        node3.left = node1
        node3.right = node5
        node1.left = node0
        node1.right = node2
        node5.left = node4
        node5.right = node6


        println(levelOrder(node3))
    }


    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root != null) {
            val queue = LinkedList<TreeNode>()
            var tempList = mutableListOf<Int>()
            var last: TreeNode? = root
            var nLast: TreeNode? = root
            queue.offer(root)

            while (queue.isNotEmpty()) {
                val node = queue.poll()
                tempList.add(node.`val`)
                if (node.left != null) {
                    last = node.left
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    last = node.right
                    queue.offer(node.right)
                }

                if (node == nLast) {
                    nLast = last
                    ans.add(tempList)
                    tempList = mutableListOf<Int>()
                }

            }

        }
        return ans
    }
}