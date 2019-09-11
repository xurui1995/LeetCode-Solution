import org.junit.Test

class Solution201 {

    @Test
    fun test() {


        println(rangeBitwiseAnd(5, 7))  // 4
        println(rangeBitwiseAnd(4, 5))  // 4
        println(rangeBitwiseAnd(0, 1))  // 0

        println(rangeBitwiseAnd(2, 2))  // 2
        println(rangeBitwiseAnd(5, 8))  // 0
        println(rangeBitwiseAnd(3, 3))  // 3
        println(rangeBitwiseAnd(2, 3))  // 2
        println(rangeBitwiseAnd(7, 8))  // 0
        println(rangeBitwiseAnd(5, 6))  // 4
        println(rangeBitwiseAnd(10, 16))  // 0


    }

    fun rangeBitwiseAnd(m: Int, n: Int): Int {
        var temp = 0
        var i = 0
        while (temp < n - m) {
            temp = (temp shl 1) + 1
            i++
        }
        if ((temp and m) + (n-m) > temp) {
            i++
            while (m and (1 shl (i-1)) != 0 ) {
                i++
            }
        }
        temp = 0
        for (j in i until 31) {
            if (m and (1 shl j) != 0) {
                temp = temp or (1 shl j)
            }
        }
        return temp
    }
}