package kotlincode

import org.junit.Test

class Solution260 {

    @Test
    fun test() {
        println(singleNumber(intArrayOf(1, 2, 1, 3, 2, 5)).toList())

    }

    fun singleNumber(nums: IntArray): IntArray {
        var a = 0
        nums.forEach {
            a = a xor it
        }
        for (i in 0..32) {
            if ((a ushr i) and 0x1 != 0) {
                a = i
                break
            }
        }

        var ans1 = 0
        var ans2 = 0
        nums.forEach {
            if ((it ushr a) and 0x1 != 0) {
                ans1 = ans1 xor it
            } else {
                ans2 = ans2 xor it
            }
        }
        return intArrayOf(ans1, ans2)
    }
}