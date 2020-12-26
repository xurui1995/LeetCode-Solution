package kotlincode

class NumMatrix(val matrix: Array<IntArray>) {

    fun sumRegion(row1: Int, col1: Int, row2: Int, col2: Int): Int {

        var rowSum = 0
        for (i in row1..row2) {
            rowSum += matrix[i][col1]
        }
        var colSum = 0
        for (j in col1 .. col2) {
            colSum += matrix[row1][j]
        }
        if (row1 == row2) {
            return colSum
        }
        if (col1 == col2) {
            return rowSum
        }
        return colSum + rowSum - matrix[row1][col1] + sumRegion(row1+1, col1+1, row2, col2)
    }

}

