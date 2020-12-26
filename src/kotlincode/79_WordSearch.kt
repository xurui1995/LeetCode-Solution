package kotlincode

import org.junit.Test

class Solution79 {

    @Test
    fun test() {
        val bord = arrayOf(
                charArrayOf('A', 'B', 'C', 'E'),
                charArrayOf('S', 'F', 'C', 'S'),
                charArrayOf('A', 'D', 'E', 'E')
        )


        println(exist(bord, "ABCCED"))
        println(exist(bord, "SEE"))
        println(exist(bord, "ABCB"))
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {

        if (board.isNotEmpty() && word.isNotEmpty()) {

            val visit = Array<BooleanArray>(board.size) { BooleanArray(board[0].size) }
            for (i in 0 until board.size) {
                for (j in 0 until board[0].size) {
                    if (board[i][j] == word[0]) {
                        visit[i][j] = true
                        if (word.length == 1 || searchStep(board, word, i, j, 0, visit)) {
                            return true
                        }
                        visit[i][j] = false
                    }
                }
            }
        }
        return false
    }

    fun searchStep(board: Array<CharArray>, word: String, i: Int, j: Int, index: Int, visit: Array<BooleanArray>): Boolean {
        if (index == word.length - 2) {
            return when {
                i < board.size - 1 && board[i + 1][j] == word[index + 1] && !visit[i + 1][j] -> true
                i > 0 && board[i - 1][j] == word[index + 1] && !visit[i - 1][j] -> true
                j < board[0].size - 1 && board[i][j + 1] == word[index + 1] && !visit[i][j + 1] -> true
                j > 0 && board[i][j - 1] == word[index + 1] && !visit[i][j - 1] -> true
                else -> false
            }
        } else {
            var ans = false
            if (!ans && i > 0 && board[i - 1][j] == word[index + 1] && !visit[i - 1][j]) {
                visit[i - 1][j] = true
                ans = searchStep(board, word, i - 1, j, index + 1, visit)
                visit[i - 1][j] = false
            }

            if (!ans && i < board.size - 1 && board[i + 1][j] == word[index + 1] && !visit[i + 1][j]) {
                visit[i + 1][j] = true
                ans = searchStep(board, word, i + 1, j, index + 1, visit)
                visit[i + 1][j] = false
            }

            if (!ans && j < board[0].size - 1 && board[i][j + 1] == word[index + 1] && !visit[i][j + 1]) {
                visit[i][j + 1] = true
                ans = searchStep(board, word, i, j + 1, index + 1, visit)
                visit[i][j + 1] = false
            }
            if (!ans && j > 0 && board[i][j - 1] == word[index + 1] && !visit[i][j - 1]) {
                visit[i][j - 1] = true
                ans = searchStep(board, word, i, j - 1, index + 1, visit)
                visit[i][j - 1] = false
            }
            return ans
        }
    }
}