package kotlincode

class Solution322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val f = IntArray(amount + 1) { -1 }
        f[0] = 0
        for (i in 1..amount) {
            var min = amount + 1
            for (j in 0 until coins.size) {
                if (coins[j] <= i) {
                    if (f[i - coins[j]] < min) {
                        min = f[i-coins[j]]
                    }
                }
            }
            f[i] = min + 1
        }
        return if (f[amount] < amount +1) f[amount] else -1
    }

}