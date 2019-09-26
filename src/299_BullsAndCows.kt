import org.junit.Test

class Solution299 {

    @Test
    fun test() {
        println(getHint("1807", "7810"))
        println(getHint("1123", "0111"))
        println(getHint("11", "01"))
        println(getHint("11", "10"))
    }

    fun getHint(secret: String, guess: String): String {
        val array = IntArray(10)
        for (i in guess.indices) {
            if (secret[i] != guess[i]) {
                array[guess[i].toString().toInt()]++
            }
        }
        var num1 = 0
        var num2 = 0
        for (i in secret.indices) {
            if (secret[i] == guess[i]) {
                num1++
            } else {
                if (array[secret[i].toString().toInt()] != 0) {
                    num2++
                    array[secret[i].toString().toInt()]--
                }
            }
        }

        return "${num1}A${num2}B"
    }
}