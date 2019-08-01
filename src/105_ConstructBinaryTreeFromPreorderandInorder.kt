import org.junit.Test

class solutioon105 {

    @Test
    fun test() {
        val node = buildTree(intArrayOf(3, 9, 20, 15, 7), intArrayOf(9, 3, 15, 20, 7))
        println(Solution102().levelOrder(node))
    }


    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty() || inorder.isEmpty()) {
            return null
        }
        return buildTree(preorder, 0, inorder, 0, inorder.lastIndex)
    }

    fun buildTree(preorder: IntArray, startPre: Int, inorder: IntArray, startIn: Int, endIn: Int): TreeNode {
        val root = TreeNode(preorder[startPre])
        var devide = 0
        for (i in startIn..endIn) {
            if (inorder[i] == preorder[startPre]) {
                devide = i
                break
            }
        }
        val num = devide - startIn
        if (devide != startIn) {
            root.left = buildTree(preorder, startPre + 1, inorder, startIn, devide - 1)
        }
        if (devide != endIn) {
            root.right = buildTree(preorder, startPre + num + 1, inorder, devide + 1, endIn)
        }
        return root
    }
}