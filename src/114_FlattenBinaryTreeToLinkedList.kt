import org.junit.Test

class Solution114 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)
        val node4 = TreeNode(4)
        val node5 = TreeNode(5)
        val node6 = TreeNode(6)
        node1.left = node2
        node1.right = node5

        node2.left = node3
        node2.right = node4

        node5.right = node6

        flatten(node1)
        println("--")

    }

    fun flatten(root: TreeNode?): Unit {
        flattenStep(root, null)
    }

    fun flattenStep(root: TreeNode?, append: TreeNode?) {
        if (root == null) {
            return
        }
        flattenStep(root.right, append)

        if (root.right == null) {
            root.right = append
        }
        if (root.left != null) {
            flattenStep(root.left, root.right)
            root.right = root.left
            root.left = null
        }
    }

}