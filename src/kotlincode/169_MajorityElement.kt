package kotlincode

import org.junit.Test

class Solution169 {

    @Test
    fun test() {
        println(majorityElement(intArrayOf(3, 2, 3)))
        println(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }

    fun majorityElement(nums: IntArray): Int {
        var ans = nums[0]
        var count = 0
        for (x in nums) {
            if (count == 0) {
                ans = x
                count = 1
            }else {
                if (x == ans) {
                    count ++
                } else {
                    count --
                }
            }
        }

        return  ans
    }
}