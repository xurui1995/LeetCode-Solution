import org.junit.Test

class Solution54 {


    @Test
    fun test() {
        val ans1 = spiralOrder(arrayOf(
                intArrayOf(1, 2, 3,4),
                intArrayOf(5,6,7,8)
        ))

        val ans2 = spiralOrder(arrayOf(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(5, 6, 7, 8),
                intArrayOf(9, 10, 11, 12)
        ))

        println(ans1)
        println(ans2)
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val ans = mutableListOf<Int>()
        if (matrix.isEmpty()) {
            return ans
        }
        var maxRow = matrix[0].size
        var maxCluomn = matrix.size
        var i = 0
        var j = 0
        while (maxRow > 1 && maxCluomn > 1) {

            for (x in 0 until maxRow -1) {
                ans.add(matrix[i][j])
                j++
            }

            for (y in 0 until maxCluomn -1) {
                ans.add(matrix[i][j])
                i++
            }

            for (x in 0 until maxRow - 1) {
                ans.add(matrix[i][j])
                j--
            }

            for (y in 0 until maxCluomn - 1) {
                ans.add(matrix[i][j])
                i--
            }

            i++
            j++

            maxCluomn -= 2
            maxRow -= 2

        }

        if (maxRow == 1 && maxCluomn == 1) {
            ans.add(matrix[i][j])
        } else if (maxRow == 1) {
            for (y in 0 until maxCluomn ) {
                ans.add(matrix[i][j])
                i++
            }
        } else if(maxCluomn == 1) {
            for (x in 0 until maxRow ) {
                ans.add(matrix[i][j])
                j++
            }
        }
        return ans
    }
}