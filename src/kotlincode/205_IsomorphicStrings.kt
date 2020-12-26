package kotlincode

import org.junit.Test

class Solution205 {

    @Test
    fun test() {
        println(isIsomorphic("egg", "add"))
        println(isIsomorphic("foo", "bar"))
        println(isIsomorphic("paper", "title"))
        println(isIsomorphic("ab", "aa"))
    }

    fun isIsomorphic(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        val map = mutableMapOf<Char, Char>()
        val mapValue = mutableSetOf<Char>()
        for (i in s.indices) {

            if (map.contains(s[i])) {

                if (t[i] != map[s[i]]) {
                    return false
                }

            } else {
                if (mapValue.contains(t[i])) {
                    return false
                }
                map[s[i]] = t[i]
                mapValue.add(t[i])
            }
        }
        return true
    }
}