package javacode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution767_ReorganizeString {

    @Test
    public void test() {
        System.out.println(reorganizeString("aab"));
        System.out.println(reorganizeString("vvvlo"));
        System.out.println(reorganizeString("eqmeyggvp"));
    }

    public String reorganizeString(String S) {
        int[][] array = new int[26][2];
        int maxCounts = 0;
        for (int i = 0; i < S.length(); i++) {
            array[S.charAt(i) - 'a'][0] = S.charAt(i) - 'a';
            array[S.charAt(i) - 'a'][1]++;
            maxCounts = Math.max(maxCounts, array[S.charAt(i) - 'a'][1]);
        }
        if (S.length() - maxCounts < maxCounts - 1) {
            return "";
        }
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < maxCounts) {
            sb.append((char) ('a' + array[0][0]));
            index++;
        }
        int gap = 1;
        index = gap;
        for (int i = 1; i < array.length; i++) {
            if (array[i][1] == 0) {
                break;
            }
            for (int j = 0; j < array[i][1]; j++) {
                sb.insert(index, (char) ('a' + array[i][0]));
                index += gap + 1;
                if (index > sb.length()) {
                    gap++;
                    index = gap;
                }
            }
        }

        return sb.toString();
    }
}
