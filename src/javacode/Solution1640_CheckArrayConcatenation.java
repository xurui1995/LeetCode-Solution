package javacode;

import org.junit.Test;

public class Solution1640_CheckArrayConcatenation {

    @Test
    public void test() {
        System.out.println(canFormArray(new int[]{1, 2, 3}, new int[][]{
                new int[]{2},
                new int[]{1, 3}
        }));
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        int[] indexs = new int[100 + 1];
        for (int i = 0; i < arr.length; i++) {
            indexs[arr[i]] = i + 1;
        }

        for (int i = 0; i < pieces.length; i++) {
            int[] piece = pieces[i];
            int last = -1;
            for (int j = 0; j < piece.length; j++) {
                int index = indexs[piece[j]];
                if (index == 0 || (last != -1 && index != last + 1)) {
                    return false;
                }
                last = index;
            }
        }
        return true;
    }

}
