package kotlincode

class Solution242 {
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) {
            return false
        }
        val array = IntArray(26)
        for (i in s) {
            array[i - 'a']++
        }

        for (i in t) {
            if (array[i-'a'] > 0) {
                array[i-'a']--
            } else {
                return false
            }
        }
        return true
    }
}