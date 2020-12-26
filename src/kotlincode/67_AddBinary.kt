package kotlincode

import org.junit.Test

class Solution67 {

    @Test
    fun test() {
        println(addBinary("1010", "1011")) //10101
        println(addBinary("11", "1")) //100
    }

    fun addBinary(a: String, b: String): String {
        val ans = StringBuilder()
        var index1 = a.length - 1
        var index2 = b.length - 1
        var add = 0
        while (index1 >= 0 && index2 >= 0) {
            ans.append((a[index1].toInt() + b[index2].toInt() + add - 2 * '0'.toInt()) % 2)
            add = (a[index1].toInt() + b[index2].toInt() + add - 2 * '0'.toInt()) / 2
            index1--
            index2--
        }
        while (index1 >= 0) {
            ans.append((a[index1].toInt() + add - '0'.toInt()) % 2)
            add = (a[index1].toInt() + add - '0'.toInt()) / 2
            index1--
        }

        while (index2 >= 0) {
            ans.append((b[index2].toInt() + add - '0'.toInt()) % 2)
            add = (b[index2].toInt() + add - '0'.toInt()) / 2
            index2--
        }

        if (add == 1) {
            ans.append(1)
        }
        return ans.reverse().toString()
    }
}