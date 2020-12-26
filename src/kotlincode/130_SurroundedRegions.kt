package kotlincode

import org.junit.Test

class Solution130 {


    @Test
    fun test() {
        val array = arrayOf(
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', '0', '0', 'X'),
                charArrayOf('X', 'X', '0', 'X'),
                charArrayOf('X', '0', 'X', 'X')
        )

        solve(array)

        println(array.joinToString(separator = "\n") { chars -> chars.joinToString { it.toString() } })
    }

    fun solve(board: Array<CharArray>): Unit {

        if (board.size <= 2) {
            return
        }

        if (board[0].size <= 2) {
            return
        }

        val helper = Array<BooleanArray>(board.size) { BooleanArray(board[0].size) }

        for (j in 0..board[0].lastIndex) {
            solveStep(board, helper, 0, j)
            solveStep(board, helper, board.lastIndex, j)
        }

        for (i in 0..board.lastIndex) {
            solveStep(board, helper, i, 0)
            solveStep(board, helper, i, board[0].lastIndex)
        }

        for (i in 0..board.lastIndex) {
            for (j in 0..board[0].lastIndex) {

                if (!helper[i][j]) {
                    board[i][j] = 'X'
                }

            }
        }
    }

    fun solveStep(board: Array<CharArray>, helper: Array<BooleanArray>, i: Int, j: Int) {
        if (i < 0 || i > board.lastIndex || j < 0 || j > board[0].lastIndex) {
            return
        }
        if (board[i][j] != 'O') {
            return
        }

        if (helper[i][j]) {
            return
        }

        helper[i][j] = true

        solveStep(board, helper, i + 1, j)
        solveStep(board, helper, i - 1, j)
        solveStep(board, helper, i, j + 1)
        solveStep(board, helper, i, j - 1)
    }
}