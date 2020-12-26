package kotlincode

import org.junit.Test
import java.util.*

class Solution103 {

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


        println(zigzagLevelOrder(node3))
    }

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val ans = mutableListOf<MutableList<Int>>()
        if (root != null) {
            val queue = LinkedList<TreeNode>()
            queue.offer(root)
            var nLast = root
            var last: TreeNode? = null
            var tempData = mutableListOf<Int>()
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                tempData.add(node.`val`)
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
                    ans.add(tempData)
                    tempData = mutableListOf<Int>()

                }
            }
            ans.forEachIndexed { index, list -> if (index and 0x1 == 1) list.reverse() }

        }
        return ans
    }
}