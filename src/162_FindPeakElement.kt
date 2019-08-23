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
        val headIsUp = nums[0] < nums[1]
        val tailIsUp = nums.last() > nums[nums.lastIndex - 1]
        return findPeakElement(nums, headIsUp, tailIsUp, 0, nums.lastIndex)

    }

    fun isPeak(nums: IntArray, index: Int): Boolean {
        val left = index == 0 || nums[index] > nums[index - 1]
        val right = index == nums.lastIndex || nums[index] > nums[index + 1]
        return left && right
    }

    fun findPeakElement(nums: IntArray, isHeadUp: Boolean, isTailUp: Boolean, start: Int, end: Int): Int {
        val mid = start + (end - start) / 2

        if (start + 1 == end || start == end) {
            if (isPeak(nums, start)) {
                return start
            } else if (isPeak(nums, end)) {
                return end
            } else {
                return -1
            }
        }


        if (isPeak(nums, mid)) {
            return mid
        }

        val isMidUp = nums[mid - 1] < nums[mid]

        if (isHeadUp && !isMidUp) {
            return findPeakElement(nums, isHeadUp, isMidUp, start, mid)
        } else if (!isTailUp && isMidUp) {
            return findPeakElement(nums, isHeadUp, isMidUp, mid + 1, end)
        } else {
            var a = findPeakElement(nums, isHeadUp, isMidUp, start, mid)
            if (a == -1) {
                a = findPeakElement(nums, isHeadUp, isMidUp, mid + 1, end)
            }
            return a
        }
    }

}