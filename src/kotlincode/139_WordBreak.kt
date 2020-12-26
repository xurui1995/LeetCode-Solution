package kotlincode

import org.junit.Test

class Solution139 {

    @Test
    fun test() {
        println(wordBreak("ccbb", listOf("bc", "cb")))
        println(wordBreak("applepenapple", listOf("apple", "pen")))
        println(wordBreak("bb", listOf("a", "b", "bbb", "bbbb")))
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        if (s.isEmpty()) {
            return false
        }
        val flags = BooleanArray(s.length)
        flags[0] = wordDict.contains(s[0].toString())
        for (i in 1..s.lastIndex) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                flags[i] = true
                continue
            }
            for (j in i - 1 downTo 0) {
                if (flags[j]) {
                    if (wordDict.contains(s.substring(j + 1, i + 1))) {
                        flags[i] = true
                        continue
                    }
                }
            }
        }
        return flags.last()
    }
}