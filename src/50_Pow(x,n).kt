class Solution50 {
    fun myPow(x: Double, n:Int): Double {

        if (x == 1.0) {
            return 1.0
        }

        if (n < 0) {
            return if (n == Int.MIN_VALUE) {
                1/x * myPow(1/x, -(n + 1))
            } else {
                myPow(1/x, -n)
            }

        }
        return when(n) {
            0 -> 1.0
            else -> {
                val result = myPow(x, n/2)
                if (n and 0x1 == 0) {
                    result * result
                } else {
                    result * result * x
                }
            }
        }
    }
}