import org.junit.Test

class Solution55 {


    @Test
    fun test() {
        println(canJump(intArrayOf(2, 3, 1, 1, 4)))
        println(canJump(intArrayOf(3, 2, 1, 0, 4)))
    }

    fun canJump(nums: IntArray): Boolean {
        if (nums.isEmpty()) {
            return false
        }
        var maxIndex = nums[0]
        if (maxIndex >= nums.size - 1) {
            return true
        }
        var i = 1
        while (i <= maxIndex) {
            if (i + nums[i] > maxIndex) {
                maxIndex = i + nums[i]
                if (maxIndex >= nums.size - 1) {
                    return true
                }
            }
            i++
        }
        return false
    }
}