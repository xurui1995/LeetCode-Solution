package javacode;

import java.util.HashSet;

public class Solution1704_StringHalvesAreAlike {

    public boolean halvesAreAlike(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int leftNum = 0;
        int rightNum = 0;
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (set.contains(s.charAt(i))) {
                leftNum++;
            }
            if (set.contains(s.charAt(j))) {
                rightNum++;
            }
            i++;
            j--;
        }
        return leftNum == rightNum;
    }
}
