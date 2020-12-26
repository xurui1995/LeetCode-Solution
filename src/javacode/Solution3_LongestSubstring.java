package javacode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution3_LongestSubstring {

    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        int ans = 1;
        int start = 0;
        int end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (start < s.length() && end < s.length()) {
            int old = map.getOrDefault(s.charAt(end), -1);
            if (old >= start) {
                start = old + 1;
            }
            map.put(s.charAt(end), end);
            ans = Math.max(ans, (end - start) + 1);
            end++;
        }
        return ans;
    }
}
