package kotlincode

import org.junit.Test

class Solution338 {

    @Test
    fun test() {
        println(countBits(10).toList())
    }

    fun countBits(num: Int): IntArray {
        val array = IntArray(num + 1)
        for (i in 1..num) {
            if (i and 0x1 == 1) {
                array[i] = array[i - 1] + 1
            } else {
                array[i] = array[i shr 1]
            }
        }

        return array
    }
}