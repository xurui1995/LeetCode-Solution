package kotlincode

import org.junit.Test

class Solution66 {

    @Test
    fun test() {
        println(plusOne(intArrayOf(9, 9, 9)).joinToString { it.toString() })
    }

    fun plusOne(digits: IntArray): IntArray {
        var add = 1
        var index = digits.size - 1
        while (add == 1 && index >= 0) {
            add = (digits[index] + 1)/10
            digits[index] = (digits[index] + 1) % 10
            index--
        }

        if (add == 1) {
            return IntArray(digits.size + 1).also {
                it[0] = 1
            }

        }
        return digits

    }
}