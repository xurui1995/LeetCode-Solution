import org.junit.Test

class Solution33 {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) {
            return -1
        }
        var left = 0
        var right = nums.lastIndex
        val isTargetLeft = target > nums.last()

        while (left + 1 < right) {
            val mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (isTargetLeft) {
                if (nums[mid] > target || nums[mid] <= nums.last()) {
                    right = mid
                } else {
                    left = mid
                }
            } else {
                if (nums[mid] < target || nums[mid] > nums.last()) {
                    left = mid
                } else {
                    right = mid
                }
            }
        }

        if (nums[left] == target) {
            return left
        }

        if (nums[right] == target) {
            return right
        }

        return -1
    }


    @Test
    fun test() {
        val array = intArrayOf(1, 3, 5)
        print(search(array, 1))
    }
}