package kotlincode

class Solution746 {
    //f(n) = min {f(n-1), f(n-2)+cost[n])
    fun minCostClimbingStairs(cost: IntArray): Int {
        val f = IntArray(3)
        f[0] = cost[0]
        f[1] = cost[1]
        for (i in 2 until cost.size) {
            f[i] = Math.min(f[i - 2] + cost[i], f[i - 1] + cost[i])
        }
        return Math.min(f[cost.size - 2], f[cost.size-1])
    }
}