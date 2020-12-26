package kotlincode

import org.junit.Test

class Solution51 {

    @Test
    fun test() {
        solveNQueens(4).also {
            for (i in it) {
                println("------")
                println(i.joinToString(separator = "\n"))
            }
        }
    }


    fun solveNQueens(n: Int): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        solveNQueenStep(IntArray(n) { -1 }, n, 0, ans)
        return ans
    }

    private fun solveNQueenStep(array: IntArray, n: Int, i: Int, ans: MutableList<List<String>>) {
        if (i < n) {
            for (x in 0 until n) {
                if (checkItem(i, x, array)) {
                    array[i] = x
                    if (i == n - 1) {
                        val result = MutableList<String>(n) { "" }
                        val charArray = CharArray(n) { '.' }
                        for (y in 0 until array.size) {
                            charArray[array[y]] = 'Q'
                            result[y] = charArray.joinToString(separator = "")
                            charArray[array[y]] = '.'
                        }
                        ans.add(result)

                    } else {
                        solveNQueenStep(array, n, i + 1, ans)
                    }
                    array[i] = -1
                }

            }
        }
    }

    fun checkItem(row: Int, col: Int, array: IntArray): Boolean {
        if (array[row] != -1) {
            return false
        }
        return array.filterIndexed { index, value ->
            value != -1 &&
                    (value == col || Math.abs(col - value).toFloat() / (row - index) == 1f)
        }.isEmpty()
    }
}