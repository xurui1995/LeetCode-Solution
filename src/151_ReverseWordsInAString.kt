import org.junit.Test

class Solution151 {


    @Test
    fun test() {
        println(reverseWords("aa  bb cc"))
    }


    fun reverseWords(s: String): String {
        return s.reversed().trim().split(' ').filter { it.isNotEmpty() }.joinToString (separator = " "){ it.reversed() }
    }


}