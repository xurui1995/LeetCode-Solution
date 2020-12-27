package javacode;

import org.junit.Test;

public class Solution392_IsSubsequence {

    @Test
    public void test() {
        System.out.println(isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence("axc", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            while (j < t.length() && t.charAt(j) != s.charAt(i)) {
                j++;
            }

            if (j < t.length()) {
                if (i == s.length() - 1) {
                    return true;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return false;
    }
}
