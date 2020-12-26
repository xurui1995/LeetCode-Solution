package kotlincode

import org.junit.Test

class Solution168 {

    @Test
    fun test() {
        println(convertToTitle(1))
        println(convertToTitle(28))
        println(convertToTitle(701))
        println(convertToTitle(52))
        println(convertToTitle(703))

    }


    fun convertToTitle(n: Int): String {
        val ans = StringBuilder()
        var newN = n
        while (true) {
            if (newN <= 26) {
                ans.append(('A' + newN - 1))
                break
            } else {
                val count = (newN -1)/ 26
                ans.append(convertToTitle(count))
                newN -= count * 26
            }
        }
        return ans.toString()
    }
}