package kotlincode

import org.junit.Test

class Solution118 {

    @Test
    fun test() {
        println(generate(6))
    }

    fun generate(numRows: Int): List<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        if (numRows >= 1) {
            ans.add(listOf(1))
            if (numRows >= 2) {
                ans.add(listOf(1, 1))
            }
        }
        for (i in 3..numRows) {
            val list = MutableList(i) { 0 }
            list[0] = 1
            list[list.lastIndex] = 1

            for (j in 1 until i-1) {
                list[j] = ans[i - 2][j - 1] + ans[i - 2][j]
            }
            ans.add(list)
        }
        return ans
    }
}