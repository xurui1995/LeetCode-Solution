package javacode;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution316_RemoveDuplicateLetters {

    @Test
    public void test() {
        System.out.println(removeDuplicateLetters("bcabc"));
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        boolean[] visited = new boolean[26];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (visited[s.charAt(i) - 'a']) {
                array[s.charAt(i) - 'a']--;
            } else {
                while (sb.length() != 0 && array[sb.charAt(sb.length() - 1) - 'a'] > 0 && sb.charAt(sb.length() - 1) > s.charAt(i)) {
                    visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(s.charAt(i));
                visited[s.charAt(i) - 'a'] = true;
                array[s.charAt(i) - 'a']--;
            }
        }
        return sb.toString();
    }
}
