package kotlincode

import org.junit.Test

class Solution125 {

    @Test
    fun test() {
        println(isPalindrome("A man, a plan, a canal: Panama"))
    }

    fun isPalindrome(s: String): Boolean {
        var start = 0
        var end = s.lastIndex
        while (start < end) {
            if (!isVaild(s[start])) {
                start++
                continue
            }
            if (!isVaild(s[end])) {
                end--
                continue
            }

            if (s[start].toLowerCase() != s[end].toLowerCase()) {
                return false
            }
            start++
            end--
        }
        return true
    }

    fun isVaild(c: Char) = (c in 'a'..'z') || (c in 'A'..'Z')||(c in '0'..'9')
}