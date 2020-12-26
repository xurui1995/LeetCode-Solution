package kotlincode

class Solution240 {

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isNotEmpty()) {
            var i = 0
            var j = matrix[0].lastIndex

            while (i <= matrix.lastIndex && j >= 0) {
                when {
                    target == matrix[i][j] -> return true
                    target > matrix[i][j] -> i++
                    else -> j--
                }
            }
        }
        return false
    }
}