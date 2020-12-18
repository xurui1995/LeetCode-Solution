import org.junit.Test

class Solution926 {

    @Test
    fun test() {
        println(minFlipsMonoIncr("00110"))
        println(minFlipsMonoIncr("010110"))
        println(minFlipsMonoIncr("00011000"))
    }


    // 0 0 1 1 0
    fun minFlipsMonoIncr(S: String): Int {
        var zeroEnd = 0
        var oneEnd = 0
        S.forEach {
            if (it == '0') {
                oneEnd = Math.min(zeroEnd, oneEnd) + 1
            } else {
                oneEnd = Math.min(zeroEnd, oneEnd)
                zeroEnd = zeroEnd + 1
            }
        }
        return Math.min(zeroEnd, oneEnd)
    }
}