package kotlincode

class Solution70 {
    fun climbStairs(n: Int): Int {
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        val f = IntArray(3)
        f[0] = 0
        f[1] = 1
        f[2] = 2
        for (i in 3 .. n) {
            f[i%3] = f[(i-2)%3]+f[(i-1)%3]
        }
        return f[n%3]
    }
}