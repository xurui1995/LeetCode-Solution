package kotlincode

import org.junit.Test

class Solution108 {

    @Test
    fun test() {
        println(Solution102().levelOrder(sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))))
    }

    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }
        return sortedArrayToBSTSTep(nums, 0, nums.lastIndex)
    }

    fun sortedArrayToBSTSTep(nums: IntArray, start: Int, end: Int): TreeNode {
        if (start == end) {
            return TreeNode(nums[start])
        } else {
            val mid = (start + end) / 2
            val root = TreeNode(nums[mid])
            if (start != mid) {
                root.left = sortedArrayToBSTSTep(nums, start, mid - 1)
            }
            if (start != end) {
                root.right = sortedArrayToBSTSTep(nums, mid + 1, end)
            }
            return root
        }
    }
}