import org.junit.Test

class Solution7 {
    @Test
    fun test() {
        println(reverse(-2147483412))
    }

    fun reverse(x: Int): Int {
        if (x == Int.MIN_VALUE) {
            return 0
        }
        var newX = x

        if (x < 0) {
            newX = -newX
        }

        var ans = 0
        while (newX != 0) {
            val end = newX % 10
            if (ans > Int.MAX_VALUE / 10 || (ans == Int.MAX_VALUE / 10 && end > 7)) {
                return 0
            }
            ans = ans * 10 + end
            newX /= 10
        }

        return if (x > 0) ans else -ans

    }
}