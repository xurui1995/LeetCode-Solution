import java.util.*

class Solution107 {


    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
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
                    ans.add(0, tempList)
                    tempList = mutableListOf<Int>()
                }

            }

        }
        return ans
    }
}