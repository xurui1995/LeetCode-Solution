import org.junit.Test

class solution98 {

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
        node2.right = TreeNode(3)
        println(isValidBST(node3))
    }


    fun isValidBST(root: TreeNode?): Boolean {

        if (root == null) {
            return true
        }

        val left = root.left?.`val`
        if (left != null && left >= root.`val`) {
            return false
        }

        val right = root.right?.`val`
        if (right != null && right <= root.`val`) {
            return false
        }

        return isValidLeftBST(root.left, root, null) && isValidLeftBST(root.right, null, root)

    }

    fun isValidLeftBST(father: TreeNode?, leftGrandFather: TreeNode?, rightGrandFather: TreeNode?): Boolean {
        if (father == null) {
            return true
        }

        if (father.left == null && father.right == null) {
            return true
        }

        if (father.left != null) {
            val leftVal = father.left?.`val`!!
            if (leftVal >= father.`val`) {
                return false
            }
            if (rightGrandFather != null) {
                if (leftVal <= rightGrandFather.`val`) {
                    return false
                }
            }
        }

        if (father.right != null) {
            val rightVal = father.right?.`val`!!
            if (rightVal <= father.`val`) {
                return false
            }
            if (leftGrandFather != null) {
                if (rightVal >= leftGrandFather.`val`) {
                    return false
                }
            }
        }
        return isValidLeftBST(father.left, father, rightGrandFather) && isValidLeftBST(father.right, leftGrandFather, father)
    }

}