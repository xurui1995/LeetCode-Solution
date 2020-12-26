package kotlincode

class Solution122 {
    fun maxProfit(prices: IntArray): Int {

        if (prices.isEmpty()) {
            return 0
        }
        val f = IntArray(prices.size)
        for (i in 1 until f.size) {
            var j = i - 1
            var max = f[i-1]
            while (j >= 0) {
                if (prices[i] > prices[j]) {
                    if (f[j] + (prices[i] - prices[j]) > max) {
                        max = f[j] + (prices[i] - prices[j])
                    }
                }
                j--
            }
            println("i = $i    max = $max")
            f[i] = max
        }
        return f[f.size - 1]
    }
}