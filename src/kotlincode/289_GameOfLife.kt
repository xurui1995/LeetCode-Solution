package kotlincode

import org.junit.Test

class Solution289 {

    @Test
    fun test() {
        val array = arrayOf(
                intArrayOf(0, 0)
        )
        gameOfLife(array)

        println(array.toList().joinToString { it.toList().toString() })
    }

    fun gameOfLife(board: Array<IntArray>): Unit {

        board.forEachIndexed { i, ints ->
            ints.forEachIndexed { j, value ->
                var count = 0
                if (i - 1 >= 0) {
                    if (board[i - 1][j] % 10 == 1) {
                        count++
                    }
                    if (j - 1 >= 0 && board[i - 1][j - 1] % 10 == 1) {
                        count++
                    }
                    if (j + 1 <= ints.lastIndex && board[i - 1][j + 1] % 10 == 1) {
                        count++
                    }
                }

                if (i + 1 <= board.lastIndex) {
                    if (board[i + 1][j] % 10 == 1) {
                        count++
                    }
                    if (j - 1 >= 0 && board[i + 1][j - 1] % 10 == 1) {
                        count++
                    }
                    if (j + 1 <= ints.lastIndex && board[i + 1][j + 1] % 10 == 1) {
                        count++
                    }
                }

                if (j - 1 >= 0 && board[i][j - 1] % 10 == 1) {
                    count++
                }
                if (j + 1 <= ints.lastIndex && board[i][j + 1] % 10 == 1) {
                    count++
                }

                if (value == 0) {
                    if (count == 3) {
                        board[i][j] += 10
                    }
                } else {
                    if (count == 2 || count == 3) {
                        board[i][j] += 10
                    }
                }

            }
        }


        for (i in 0..board.lastIndex) {
            for (j in 0..board[0].lastIndex) {
                board[i][j] /= 10
            }
        }
    }
}