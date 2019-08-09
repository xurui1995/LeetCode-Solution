import org.junit.Test

class Solution129 {

    @Test
    fun test() {
        val node1 = TreeNode(1)
        val node2 = TreeNode(2)
        val node3 = TreeNode(3)

        node1.left = node2
        node1.right = node3


        println(sumNumbers(node1))
    }


    fun sumNumbers(root: TreeNode?): Int {
        return if (root == null) 0 else sumNumbersTemp(root, "")
    }

    fun sumNumbersTemp(root: TreeNode, prefix: String): Int {
        if (root.left == null && root.right == null) {
            return (prefix + root.`val`).toInt()
        }
        var ans = 0
        if (root.left != null) {
            ans += sumNumbersTemp(root.left!!, prefix + root.`val`)
        }
        if (root.right != null) {
            ans += sumNumbersTemp(root.right!!, prefix + root.`val`)
        }
        return ans
    }
}