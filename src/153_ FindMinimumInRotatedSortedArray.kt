import org.junit.Test

class Solution153 {

    @Test
    fun test() {
        println(findMin(intArrayOf(2, 0)))
        println(findMin(intArrayOf(3,4,5,1,2)))
        println(findMin(intArrayOf(3,4,5)))
    }

    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.lastIndex
        while (left + 1  < right) {
            var mid = left + (right - left)/2
            if (nums[mid]< nums[mid-1]) {
                return nums[mid]
            } else {
                if (nums[mid] > nums.last()) {
                    left = mid
                } else {
                    right = mid
                }
            }
        }

        return Math.min(nums[left], nums[right])
    }
}