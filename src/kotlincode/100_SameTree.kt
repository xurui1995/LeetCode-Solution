package kotlincode

/**
 * Example:
 * var ti = kotlincode.TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class kotlincode.TreeNode(var `val`: Int) {
 *     var left: kotlincode.TreeNode? = null
 *     var right: kotlincode.TreeNode? = null
 * }
 */
class Solution100 {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        return when {
            p == null && q == null -> true
            p?.`val` != q?.`val` -> false
            else -> isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        }
    }
}