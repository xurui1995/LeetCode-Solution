package kotlincode

class Solution263 {
    fun isUgly(num: Int): Boolean {
        if (num == 1 || num == 2 || num == 3 || num == 5) {
            return true
        }
        if (num <= 0) {
            return false
        }
        var result = num
        while (result % 2 ==0 ) {
            result /= 2
        }
        while (result % 3 ==0 ) {
            result /= 3
        }

        while (result % 5 ==0 ) {
            result /= 5
        }

        return result == 1

    }
}