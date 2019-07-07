import org.junit.Test

class Solution231 {

    @Test
    fun test() {
        println(isPowerOfTwo(1))
        println(isPowerOfTwo(16))
        println(isPowerOfTwo(3))
    }


    fun isPowerOfTwo(n: Int): Boolean {
        if (n <= 0) {
            return false
        }
        return (n and (n-1)) == 0
    }
}