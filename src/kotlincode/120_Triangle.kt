package kotlincode

class Solution120 {
    fun minimumTotal(triangle: List<MutableList<Int>>): Int {
        for (i in 1 until triangle.size) {
            for (j in 0 until triangle[i].size) {
                when (j) {
                    0 -> triangle[i][j] = triangle[i - 1][j] + triangle[i][j]
                    triangle[i].size - 1 -> triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j]
                    else -> triangle[i][j] = Math.min(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j]
                }
            }
        }
        triangle[triangle.size-1].sort()
        return triangle[triangle.size-1][0]
    }
}