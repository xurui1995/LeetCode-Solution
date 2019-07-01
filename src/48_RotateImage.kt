import org.junit.Test

class Solution48 {

    @Test
    fun test() {
        val array1 = intArrayOf(1,2,3)
        val array2 = intArrayOf(4,5,6)
        val array3 = intArrayOf(7,8,9)

        val matrix = arrayOf(array1, array2, array3)
        rotate(matrix)

        println(matrix.joinToString { array -> array.joinToString { it.toString() } })
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        transpose(matrix)
        var left = 0
        var right = matrix[0].size - 1
        while (left < right) {
            for (i in 0 until matrix.size) {
                val temp = matrix[i][left]
                matrix[i][left] = matrix[i][right]
                matrix[i][right] = temp
            }
            left ++
            right --
        }
    }

    fun transpose(matrix: Array<IntArray>) {
        for (i in 0 until matrix.size) {
            for (j in i until matrix[0].size) {
                val temp =  matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }
    }
}