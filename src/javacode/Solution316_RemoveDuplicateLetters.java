package javacode;

import org.junit.Test;

public class Solution316_RemoveDuplicateLetters {

    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public String removeDuplicateLetters(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            array[c - 'a'] = 1;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                char c = (char) ('a' + i);
                ans.append(c);
            }
        }
        return ans.toString();
    }
}
