import org.junit.Test

class Solution202 {


    @Test
    fun test() {
        println(isHappy(19))
        println(isHappy(18))
    }

    fun isHappy(n: Int): Boolean {
        val set = HashSet<Int>()
        var newN = n
        var temp = 0
        while (!set.contains(newN)) {
            set.add(newN)
            while (newN != 0) {
                temp += (newN % 10) * (newN % 10)
                newN /= 10
            }
            if (temp == 1) {
                return true
            }
            newN = temp
            temp = 0
        }
        return false
    }


}