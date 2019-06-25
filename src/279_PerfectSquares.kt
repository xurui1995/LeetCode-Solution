class Solution279 {
    fun numSquares(n: Int): Int {
        val  dp = IntArray(n+1){ Int.MAX_VALUE}
        dp[0] = 0
        for (i in 1 .. n) {
            var j = 1
            while (i - j*j >= 0) {
                dp[i] = Math.min(dp[i], dp[i-j*j] + 1)
                j++
            }
        }
        return dp[n]
    }
}