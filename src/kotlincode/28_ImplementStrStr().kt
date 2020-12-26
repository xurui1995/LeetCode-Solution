import org.junit.Test

class Solution28 {
    fun strStr(haystack: String, neddle: String): Int {
        if (neddle.isEmpty()) {
            return 0
        }

        val nexts = getNext(neddle)
        var i = 0
        var j = 0

        while (i < haystack.length && j < neddle.length) {
            if (haystack[i] == neddle[j]) {
                if (j == neddle.length - 1) {
                    return i - j
                } else {
                    j++
                    i++
                }
            } else {
                var next = nexts[j]
                if (next == -1) {
                    i++
                    j = 0
                } else {
                    j = next
                }
            }
        }

        return -1

    }

    fun getNext(str: String): IntArray {
        val next = IntArray(str.length)
        next[0] = -1
        var j = 0
        var k = -1
        while (j < str.length - 1) {
            if (k == -1 || str[j] == str[k]) {
                j++
                k++
                next[j] = k
            } else {
                k = next[k]
            }
        }
        return next
    }


    fun sunday(haystack: String, neddle: String): Int {
        var i = 0
        if (haystack == neddle) {
            return 0
        }
        while (i <= haystack.lastIndex) {
            if (isOk(haystack, neddle, i)) {
                return i
            } else {
                i += neddle.length
                if (i <= haystack.lastIndex) {
                    val index = neddle.lastIndexOf(haystack[i])
                    if (index != -1) {
                        i -= index
                    } else {
                        i++
                    }
                }
            }
        }
        return -1
    }

    fun isOk(haystack: String, neddle: String, index: Int): Boolean {
        if (index + neddle.length - 1 > haystack.lastIndex) {
            return false
        }
        for (i in index until index + neddle.length) {
            if (haystack[i] != neddle[i - index]) {
                return false
            }
        }
        return true
    }


    @Test
    fun test() {
        println(getNext("ABAB").toList())

        println(strStr("hello", "ll"))
        println(strStr("aaaaa", "bba"))
        println(strStr("thisisbba", "is"))


        println(sunday("hello", "ll"))
        println(sunday("aaaaa", "bba"))
        println(sunday("", ""))
    }
}