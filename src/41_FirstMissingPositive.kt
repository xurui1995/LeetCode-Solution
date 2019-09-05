import org.junit.Test
import kotlin.math.abs

class Solution41 {

    @Test
    fun test() {
        firstMissingPositive(intArrayOf(1, 2, 0)).also { println(it) }
        firstMissingPositive(intArrayOf(3, 4, -1, 1)).also { println(it) }
        firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)).also { println(it) }
    }

    fun firstMissingPositive(nums: IntArray): Int {
        if (nums.contains(1).not()) {
            return 1
        }

        if (nums.max() == 1) {
            return 2
        }

        for (i in nums.indices) {
            if (nums[i] <= 0) {
                nums[i] = 1
            }
        }

        for (i in nums.indices) {
            if (Math.abs(nums[i]) <= nums.size && nums[abs(nums[i]) - 1] > 0) {
                nums[abs(nums[i]) - 1] = - nums[abs(nums[i]) - 1]
            }
        }

        for (i in nums.indices) {
            if (nums[i] > 0) {
                return i +1
            }
        }
        return nums.size + 1
    }
}