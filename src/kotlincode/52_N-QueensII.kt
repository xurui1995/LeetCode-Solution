package kotlincode

import org.junit.Test

class Solution52 {


    @Test
    fun test() {
        val a = Solution52()
        a.totalNQueens(8)
        print(a.ans)

    }

    var ans = 0

    fun totalNQueens(n: Int): Int {
        totalNQueensByStep(n, 0, IntArray(n){-1})
        return ans
    }

    fun totalNQueensByStep(n: Int, index: Int, array: IntArray) {
        if (index <= n-1) {
            for (x in 0 until  n) {
                if (checkItem(index, x, array)) {
                    array[index] = x
                    if (index == n-1) {
                        ans++
                    }else {
                        totalNQueensByStep(n, index +1, array)
                    }
                    array[index] = -1
                }
            }
        }
    }


    fun checkItem(row: Int, col:Int, array:IntArray): Boolean {

        if (array[row] != -1) {
            return false
        }
        return array.filterIndexed { index, value -> value != -1 &&
                (value == col || Math.abs(col - value).toFloat()/(row - index) == 1f) }.isEmpty()
    }
}