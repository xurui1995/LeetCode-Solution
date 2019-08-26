import org.junit.Test

class solution173 {

    @Test
    fun test() {
        val node1 = TreeNode(7)
        val node2 = TreeNode(3)
        val node3 = TreeNode(15)
        val node4 = TreeNode(9)
        val node5 = TreeNode(20)
        node1.left = node2
        node1.right = node3
        node3.left = node4
        node3.right = node5

        val iterator = BSTIterator(node1)
        println(iterator.next())
        println(iterator.next())
        println(iterator.hasNext())
        println(iterator.next())
        println(iterator.hasNext())
        println(iterator.next())
        println(iterator.hasNext())
        println(iterator.next())
        println(iterator.hasNext())
    }

}


class BSTIterator(root: TreeNode?) {

    /** @return the next smallest number */
    val valueList = mutableListOf<Int>()
    var index = 0

    init {
        traversal(root)
    }

    fun traversal(root: TreeNode?) {
        if (root != null) {
            traversal(root.left)
            valueList.add(root.`val`)
            traversal(root.right)
        }
    }

    fun next(): Int {
        return valueList[index++]
    }

    /** @return whether we have a next smallest number */
    fun hasNext(): Boolean {
        return index <= valueList.lastIndex
    }

}