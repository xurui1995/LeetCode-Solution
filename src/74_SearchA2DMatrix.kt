import org.junit.Test

class Solution74 {


    @Test
    fun test() {
        val matrix = arrayOf(intArrayOf(1,3,5,7),
                intArrayOf(10,11,16,20),
                intArrayOf(23,30,34,50))

        println(searchMatrix(matrix, 3))
        println(searchMatrix(matrix, 13))
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }

        var colIndex = matrix[0].lastIndex
        var rowIndex = 0

        while (colIndex >= 0 && rowIndex <=  matrix.lastIndex) {
            when {
                matrix[rowIndex][colIndex] == target -> return true
                matrix[rowIndex][colIndex] > target ->  colIndex --
                else -> rowIndex++
            }
        }
        return false
    }
}