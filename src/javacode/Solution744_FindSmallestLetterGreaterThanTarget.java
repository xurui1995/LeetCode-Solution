package javacode;

import org.junit.Test;

public class Solution744_FindSmallestLetterGreaterThanTarget {

    @Test
    public void test() {
        System.out.println(nextGreatestLetter(new char[]{'e', 'e', 'e', 'k', 'q', 'q', 'q', 'v', 'v', 'y'}, 'e'));
    }


    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] > target && letters[mid - 1] <= target) {
                return letters[mid];
            } else if (letters[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (letters[start] > target) {
            return letters[start];
        }

        if (letters[end] > target) {
            return letters[end];
        }

        return letters[0];
    }
}
