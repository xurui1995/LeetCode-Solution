class Solution258 {
    fun addDigits(num: Int): Int {
        return if (num < 10) {
            num
        } else {
            var n = num
            var new = 0
            while (n != 0) {
                new += n%10
                n /= 10
            }
            addDigits(new)
        }
    }
}