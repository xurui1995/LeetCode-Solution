package kotlincode

import org.junit.Test

class Solution58 {


    @Test
    fun test() {
        print(lengthOfLastWord("Hello WORLD"))
    }

    fun lengthOfLastWord(s: String): Int {
        var last = -1
        var ans = 0
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ') {
                if (last == -1) {
                    last = i
                }
                ans++
            } else {
                if (last != -1) {
                    break
                }
            }
        }
        return ans
    }
}