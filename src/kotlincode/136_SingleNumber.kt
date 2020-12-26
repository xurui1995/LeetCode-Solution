package kotlincode

import org.junit.Test

class Solution136 {

    @Test
    fun test() {
        print(singleNumber(intArrayOf(3, 4, 5, 5, 3, 7, 4)))
    }

    fun singleNumber(nums: IntArray): Int {
        var ans = nums[0]
        for (i in 1 until nums.size) {
            ans = ans xor nums[i]
        }
        return ans
    }
}