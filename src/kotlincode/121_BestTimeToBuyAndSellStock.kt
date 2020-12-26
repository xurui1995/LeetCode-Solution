package kotlincode

class Solution121 {
    fun maxProfit(prices: IntArray): Int {
        var min = Int.MAX_VALUE
        var result = 0
        for (i in 0 until prices.size) {
            if (prices[i] >= min) {
                if (prices[i] - min > result) {
                    result = prices[i] - min
                }
            } else {
                min = prices[i]
            }
        }
        return result
    }
}