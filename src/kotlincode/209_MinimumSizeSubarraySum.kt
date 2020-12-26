package kotlincode

import org.junit.Test

class Solution209 {

    @Test
    fun test() {
        println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
        println(minSubArrayLen(7, intArrayOf(2, 3, 6, 2, 3, 3)))
        println(minSubArrayLen(7, intArrayOf()))
    }


    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        var ans = Int.MAX_VALUE
        var start = 0
        var end = 0
        var temp = 0
        while (end < nums.size) {
            if (nums[end] >= s) {
                return 1
            } else {
                temp += nums[end]
                if (temp >= s) {

                    while (temp >= s )  {
                        temp -= nums[start]
                        start++
                    }
                    if (end - start + 2 < ans) {
                        ans = end - start + 2
                    }
                    end ++
                } else {
                    end ++
                }
            }
        }
        return if (ans == Int.MAX_VALUE) 0 else ans
    }
}