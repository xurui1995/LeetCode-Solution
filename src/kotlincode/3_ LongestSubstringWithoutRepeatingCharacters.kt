import org.junit.Test
import kotlin.math.max

class Solution3 {

    @Test
    fun test() {
        var s = "abcabcbb"
        print(lengthOfLongestSubstring(s))
        s = "bbbbb"
        print(lengthOfLongestSubstring(s))
        s = "pwwkew"
        print(lengthOfLongestSubstring(s))
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val map = hashMapOf<Char, Int>()
        var ans = 0;
        var i = 0
        var j = 0

        while (i < s.length && j < s.length) {
            if (map.containsKey(s[j])) {
                val index = map.getOrDefault(s[j], 0)
                i = max(index + 1, i)
            }

            map.put(s[j], j)
            j++
            ans = max(j - i, ans)
        }
        return ans;
    }
}