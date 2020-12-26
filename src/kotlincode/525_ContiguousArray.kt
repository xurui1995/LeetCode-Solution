package kotlincode

import org.junit.Test
import kotlin.collections.HashMap

class Solution525 {


    @Test
    fun test() {
        println(findMaxLength(intArrayOf(0, 1, 1, 0, 1, 1, 1, 0)))
        println(findMaxLength(intArrayOf(0,1)))
        println(findMaxLength(intArrayOf(0,1,0)))
    }

    fun findMaxLength(nums: IntArray): Int {
        var ans = 0
        val map = HashMap<Int, Int>()
        var sum = 0
        for (i in nums.indices) {
            if (nums[i] == 1) {
                sum += 1
            } else {
                sum -= 1
            }

            if (sum == 0) {
                ans = Math.max(ans, i+1)
            }
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map[sum]!!)
            } else {
                map[sum] = i
            }
        }

        return ans
    }
}