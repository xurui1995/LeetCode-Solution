package kotlincode

import org.junit.Test

class Solution119 {

    @Test
    fun test() {
        println(getRow(1))
        println(getRow(2))
        println(getRow(3))
        println(getRow(4))
        println(getRow(5))
        println(getRow(6))
    }

    fun getRow(rowIndex: Int): List<Int> {
        val ans = MutableList(rowIndex + 1) { 1 }
        for (i in 2..rowIndex) {
            for (j in i / 2 downTo 1) {
                ans[j] = ans[j - 1] + ans[j]
            }
            if (i and 0x1 == 1) {
                ans[i / 2 + 1] = ans[i / 2]
            }
        }
        if (rowIndex > 3) {
            for (i in rowIndex - 1 downTo ((rowIndex + 1) / 2)) {
                ans[i] = ans[rowIndex - i]
            }
        }
        return ans
    }
}