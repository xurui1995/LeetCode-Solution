import org.junit.Test

class Solution106 {

    @Test
    fun test() {
        val node = buildTree(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3))
        println(Solution102().levelOrder(node))
    }

    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (inorder.isEmpty()) {
            return null
        }
        return buildTree(inorder, 0, inorder.lastIndex, postorder, postorder.lastIndex)
    }

    fun buildTree(inorder: IntArray, startIn: Int, endIn: Int, postorder: IntArray, endPost: Int): TreeNode {
        val root = TreeNode(postorder[endPost])
        var divide = 0
        for (i in startIn..endIn) {
            if (inorder[i] == postorder[endPost]) {
                divide = i
                break
            }
        }
        if (divide != startIn) {
            root.left = buildTree(inorder, startIn, divide - 1, postorder, divide - startIn)
        }
        if (divide != endIn) {
            root.right = buildTree(inorder, divide + 1, endIn, postorder, endPost - 1)
        }

        return root
    }
}