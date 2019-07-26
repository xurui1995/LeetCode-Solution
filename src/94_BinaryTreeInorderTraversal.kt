import org.junit.Test
import java.util.*

class Solution94 {


    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        node1.right = node2
        node2.left = node3

        println(inorderTraversal(node1))
    }


    fun inorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        var node = root
        while (node != null || stack.isNotEmpty()) {
            while (node != null) {
                stack.push(node)
                node = node.left
            }

            if (stack.isNotEmpty()) {
                val pop = stack.pop()
                ans.add(pop.`val`)
                node = pop.right
            }
        }
        return ans
    }
}