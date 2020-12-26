package kotlincode

import org.junit.Test

class Solution162 {

    @Test
    fun test() {
        println(findPeakElement(intArrayOf(1, 2, 3, 1, -1)))
        println(findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
        println(findPeakElement(intArrayOf(2, 3, 4)))
        println(findPeakElement(intArrayOf(4)))

    }

    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) {
            return 0
        }
        var left = 0
        var right = nums.lastIndex
        while (left + 1< right) {
            val mid = left + (right - left)/2
            if (isPeak(nums, mid)) {
                return mid
            }
            if (nums[mid] < nums[mid+1]) {
                left = mid
            } else {
                right = mid
            }
        }
        return if (nums[left] > nums[right]) left else right
    }


    fun isPeak(nums: IntArray, index: Int): Boolean {
        val left = index == 0 || nums[index] > nums[index - 1]
        val right = index == nums.lastIndex || nums[index] > nums[index + 1]
        return left && right
    }


}