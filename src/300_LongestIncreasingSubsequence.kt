class Solution300 {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size){1}
        var max = if(nums.isEmpty()) 0 else 1
        for (i in 1 until nums.size) {
            for (j in i-1 downTo 0) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1)
                }
            }
            if (dp[i] > max) {
                max = dp[i]
            }
        }
        return max
    }
}