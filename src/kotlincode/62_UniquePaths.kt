package kotlincode

class Solution62 {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m <=0 || n <= 0) {
            return 0
        }
        val f = Array(m) {IntArray(n){1}}
        for (i in 1 until m) {
            for (j in 1 until  n) {
                f[i][j] = f[i-1][j] + f[i][j-1]
            }
        }
        return f[m-1][n-1]
    }
}