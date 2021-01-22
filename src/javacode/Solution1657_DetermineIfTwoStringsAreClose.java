package javacode;

import java.util.HashMap;

public class Solution1657_DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for (char c : word2.toCharArray()) {
            array2[c - 'a']++;
        }
        for (char c : word1.toCharArray()) {
            array1[c - 'a']++;
        }
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < array2.length; i++) {
            if (array2[i] != 0) {
                map.put(array2[i], map.getOrDefault(array2[i], 0) + 1);
            }
        }

        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == 0 && array2[i] == 0) {
                continue;
            }
            if (array1[i] == 0 && array2[i] != 0) {
                return false;
            }
            if (array2[i] == 0 && array1[i] != 0) {
                return false;
            }

            int value = map.getOrDefault(array1[i], 0);
            if (value == 0) {
                return false;
            }
            map.put(array1[i], value - 1);
        }
        return true;
    }
}
