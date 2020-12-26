package kotlincode

import org.junit.Test

class Solution171 {


    @Test
    fun test() {
        println(titleToNumber("A"))
        println(titleToNumber("AB"))
        println(titleToNumber("AAA"))
    }

    fun titleToNumber(s: String): Int {
        var ans = 0
        var next = 1
        for (i in s.lastIndex downTo  0) {
            ans += next * (s[i] - 'A' + 1)
            next*=26
        }
        return ans
    }
}