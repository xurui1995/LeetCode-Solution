package kotlincode

class Solution36 {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        return isValidCol(board) && isValidRow(board) && isValidSubBox(board)
    }

    fun isValidCol(board: Array<CharArray>): Boolean {
        val record = HashSet<Char>(9)
        for (array in board) {
            record.clear()
            for (i in array) {
                if (i != '.') {
                    if (record.contains(i)) {
                        return false
                    } else {
                        record.add(i)
                    }
                }
            }
        }
        return true
    }


    fun isValidRow(board: Array<CharArray>): Boolean {
        val record = HashSet<Char>(9)
        for (i in 0 until  9) {
            record.clear()
            for (j in 0 until  9) {
                if (board[j][i] != '.') {
                    if (record.contains(board[j][i])) {
                        return false
                    } else {
                        record.add(board[j][i])
                    }
                }
            }
        }
        return true
    }


    fun isValidSubBox(board: Array<CharArray>): Boolean {
        val record = HashSet<Char>(9)
        for (i in 0 until 9 step 3) {
            for (j in 0 until 9 step 3) {
                record.clear()
                for (x in i until i+3) {
                    for (y in j until j+3) {
                        if (board[x][y] != '.') {
                            if (record.contains(board[x][y])) {
                                return false
                            } else {
                                record.add(board[x][y])
                            }
                        }
                    }
                }
            }
        }

        return true
    }
}