import org.junit.Test

class Solution {

    @Test
    fun test() {
        val a = intArrayOf(3)
        println(searchInsert(a, 5))
        println(searchInsert(a, 2))
        println(searchInsert(a, 7))
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = (left + right)/2
            when {
                nums[mid] == target -> {
                    return mid
                }
                nums[mid] > target -> {
                    right = mid
                }
                else -> {
                    left = mid + 1
                }
            }
        }
        return if (nums[left] >= target) left else left + 1
    }

}