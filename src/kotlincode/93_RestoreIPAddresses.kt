package kotlincode

import org.junit.Test

class Solution93 {

    @Test
    fun test() {
        println(restoreIpAddresses("0690"))
        println(restoreIpAddresses("25525511135"))
        println(restoreIpAddresses("0000"))
        println(restoreIpAddresses("010010"))
        println(restoreIpAddresses("1111"))
        println(restoreIpAddresses("172162541"))
        println(restoreIpAddresses("000256"))
    }

    fun restoreIpAddresses(s: String): List<String> {
        val ans = mutableListOf<String>()
        helper(s, 0, 0, StringBuilder(), ans)
        return ans
    }

    fun helper(s: String, index: Int, num: Int, temp: StringBuilder, ans: MutableList<String>) {
        if (index > s.lastIndex) {
            return
        }
        if (num == 3) {
            if (s.lastIndex - index >= 3) {
                return
            }
            if (s[index] == '0' && s.lastIndex != index) {
                return
            }

            val str = s.substring(index)
            if (str.toInt() > 255) {
                return
            }
            ans.add(temp.toString() + str)
        } else {
            if (s[index] == '0') {
                val v = "0."
                temp.append(v)
                helper(s, index + 1, num + 1, temp, ans)
                temp.delete(temp.length - v.length, temp.length)
            } else {
                var max = if (s[index] <= '2') index + 3 else index + 2
                if (max >= s.length) {
                    max = s.length
                }
                for (i in index + 1..max) {
                    var v = s.substring(index, i)
                    if (v.toInt() > 256) {
                        continue
                    }
                    v+="."
                    temp.append(v)
                    helper(s, i, num + 1, temp, ans)
                    temp.delete(temp.length - v.length, temp.length)
                }
            }
        }
    }
}