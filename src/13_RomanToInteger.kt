import org.junit.Test

class Solution13 {

    @Test
    fun test() {
        println(romanToInt("IV"))
        println(romanToInt("IX"))
        println(romanToInt("LVIII"))
        println(romanToInt("MCMXCIV"))
    }

    val map = hashMapOf<Char, Int>('I' to 1, 'V' to 5, 'X' to 10, 'L' to 50, 'C' to 100, 'D' to 500, 'M' to 1000)

    fun romanToInt(s: String): Int {
        var ans = 0
        var temp = 0
        for (i in s.lastIndex downTo 0) {
            val value = map.getValue(s[i])
            if (value >= temp) {
                ans += value
                temp = value
            } else {
                ans -= value
            }
        }
        return ans
    }
}