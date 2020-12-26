package kotlincode

import org.junit.Test

class Solution59 {

    @Test
    fun test() {
        val a = generateMatrix(2)
        println(a.joinToString(separator = "\n") {
            it.joinToString { i -> i.toString() }
        })
    }


    fun generateMatrix(n: Int): Array<IntArray> {
        val ans = Array<IntArray>(n) { IntArray(n) { 0 } }
        var temp = 0
        var max = n
        var i = 0
        var j = 0
        while (max > 1) {
            for (a in 0 until max - 1) {
                ans[i][j] = ++temp
                j++
            }

            for (a in 0 until max - 1) {
                ans[i][j] = ++temp
                i++
            }

            for (a in 0 until max - 1) {
                ans[i][j] = ++temp
                j--
            }

            for (a in 0 until max - 1) {
                ans[i][j] = ++temp
                i--
            }
            i++
            j++
            max -= 2
        }

        if (max == 1) {
            ans[i][j] = ++temp
        }

        return ans
    }

}