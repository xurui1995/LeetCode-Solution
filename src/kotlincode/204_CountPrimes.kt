package kotlincode

import org.junit.Test

class Solution204 {


    @Test
    fun test() {
        println(countPrimes(1))
        println(countPrimes(2))
        println(countPrimes(10))
        println(countPrimes(0))
    }

    fun countPrimes(n: Int): Int {
        val array = BooleanArray(n + 1) { true }
        array[0] = false
        var ans = 0
        for (i in 0 until n) {
            if (array[i].not() || i == 1) {
                continue
            }
            ans++
            var temp = i * 2
            while (temp < n) {
                array[temp] = false
                temp += i
            }

        }
        return ans
    }
}