package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1329_SortTheMatrixDiagonally {

    @Test
    public void test() {
        int[][] mat = {
                {3, 3, 1, 1},
                {2, 2, 1, 2},
                {1, 1, 1, 2}
        };
        diagonalSort(mat);
    }

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int i = m - 1;
        int j = 0;
        while (i >= 0) {
            int i2 = i;
            int j2 = 0;
            List<Integer> list = new ArrayList();
            while (j2 < n && i2 < m) {

                list.add(mat[i2][j2]);
                j2++;
                i2++;
            }
            Collections.sort(list);
            i2 = i;
            j2 = 0;
            int index = 0;
            while (j2 < n && i2 < m) {
                mat[i2][j2] = list.get(index);
                index++;
                j2++;
                i2++;
            }
            i--;
        }
        i = 1;
        j = 1;
        while (j < n) {
            int i2 = 0;
            int j2 = j;
            List<Integer> list = new ArrayList();
            while (j2 < n && i2 < m) {
                list.add(mat[i2][j2]);
                j2++;
                i2++;
            }
            Collections.sort(list);
            i2 = 0;
            j2 = j;
            int index = 0;
            while (j2 < n && i2 < m) {
                mat[i2][j2] = list.get(index);
                index++;
                j2++;
                i2++;
            }
            j++;
        }

        return mat;
    }
}
