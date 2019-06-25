package LeetCode

import org.junit.Test

class Solution38 {

    @Test
    fun test() {
        for (i in 1 .. 10) {
            println(countAndSay(i))
        }
    }

    fun countAndSay(n: Int): String {
        var ans = "1"
        if (n == 1) {
            return ans
        }
        for (i in 2 .. n) {
            var num = ans[0]
            var count = 1
            var newAns = ""

           for (j in 1 until  ans.length) {
               when (num) {
                   ans[j] -> count ++
                   else -> {
                       newAns += count
                       newAns += num
                       num = ans[j]
                       count = 1
                   }
               }
           }
            newAns += count
            newAns += num
            ans = newAns
        }
        return ans
    }
}
