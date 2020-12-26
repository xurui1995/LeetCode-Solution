package kotlincode

import org.junit.Test
import java.util.*

class Solution230 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)

        node2.left = node1
        node3.left = node2
        node3.right = node4

        node5.left = node3
        node5.right = node6


        print(kthSmallest(node5, 3))
    }

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = Stack<TreeNode>()
        var node = root
        var count = 0
        while (stack.isNotEmpty() || node != null) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }

            if (stack.isNotEmpty()) {
                val temp = stack.pop()
                count ++
                if (count == k) {
                    return temp .`val`
                } else {
                    node = temp.right
                }
            }
        }

        return -1
    }


}