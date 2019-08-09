import org.junit.Test
import java.util.*

class Solution131 {

    @Test
    fun test() {
        println(partition("aacbb"))
    }

    fun partition(s: String): List<List<String>> {
        val ans = mutableListOf<List<String>>()
        val list = LinkedList<String>()
        partitionStep(s, 0, ans, list)
        return ans
    }


    fun partitionStep(s: String, index: Int, ans: MutableList<List<String>>, list: LinkedList<String>) {
        if (index == s.length) {
            ans.add(list.toList())
        } else {
            var temp = ""
            for (i in index..s.lastIndex) {
                if (isPalindrome(s, index, i)) {
                    temp = s.substring(index, i + 1)
                    list.add(temp)
                    partitionStep(s, i + 1, ans, list)
                    list.pollLast()
                }
            }

        }
    }

    fun isPalindrome(s: String, start: Int, end: Int): Boolean {
        var newStart = start
        var newEnd = end
        while (newStart < newEnd) {
            if (s[newEnd] != s[newStart]) {
                return false
            }
            newStart++
            newEnd--
        }
        return true
    }
}