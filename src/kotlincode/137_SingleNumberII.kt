package kotlincode

import org.junit.Test

class Solution137 {

    @Test
    fun test() {
        println(singleNumber(intArrayOf(2, 2, 3, 2)))
    }

    fun singleNumber(nums: IntArray): Int {
        var ans = 0
        for (i in 0..32) {
            val temp = 1 shl i
            var sum = 0
            for (num in nums) {
                if (num and temp != 0) {
                    sum++
                }
            }
            if (sum % 3 == 1) {
                ans = ans or temp
            }
        }
        return ans
    }
}