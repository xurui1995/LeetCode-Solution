package kotlincode

class Solution264 {
    fun nthUglyNumber(n: Int): Int {
        val f = IntArray(n)
        f[0] = 1

        var twoIndex = 0
        var threeIndex = 0
        var fiveIndex = 0

        var twoValue = 2
        var threeValue = 3
        var fiveValue = 5

        for (i in 1 until n) {
            val min = Math.min(twoValue, Math.min(threeValue, fiveValue))
            f[i] = min
            if (min == twoValue) {
                twoValue = f[++twoIndex]*2
            }
            if (min == threeValue) {
                threeValue = f[++threeIndex]*3
            }
            if (min == fiveValue) {
                fiveValue = f[++fiveIndex]*5
            }
        }
        return f[n-1]
    }
}