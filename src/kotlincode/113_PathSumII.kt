package kotlincode

class Solution113 {

    fun pathSum(root: TreeNode?, sum: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (root != null) {
            pathSumStep(root, 0, sum, ans, mutableListOf())
        }
        return ans
    }

    fun pathSumStep(root: TreeNode, sum: Int, target: Int, ans: MutableList<List<Int>>, temp: MutableList<Int>) {
        if (root.left == null && root.right == null) {
            if (sum + root.`val` == target) {
                temp.add(root.`val`)
                ans.add(temp.toList())
                temp.removeAt(temp.lastIndex)
            }
        } else {
            temp.add(root.`val`)
            if (root.left != null) {
                pathSumStep(root.left!!, sum + root.`val`, target, ans, temp)
            }

            if (root.right != null) {
                pathSumStep(root.right!!, sum + root.`val`, target, ans, temp)
            }
            temp.removeAt(temp.lastIndex)
        }
    }
}