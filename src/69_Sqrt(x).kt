import org.junit.Test

class Solution69 {

    @Test
    fun test() {
        println(mySqrt(10))
    }

    fun mySqrt(x: Int): Int {

        if (x < 4) {
            return if (x == 0) 0  else 1
        }
        var left = 0
        var right = x
        while (true) {
            val mid = left + (right - left)/2

            when {
                mid > x / mid -> right = mid -1
                mid == x/mid -> return mid
                else -> {
                    if (mid + 1 > x/(mid+1)) {
                        return mid
                    }
                    left = mid +1
                }
            }
        }
    }
}