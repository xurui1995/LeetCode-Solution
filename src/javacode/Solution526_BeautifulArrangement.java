package javacode;

import org.junit.Test;

import java.util.Arrays;

public class Solution526_BeautifulArrangement {

    @Test
    public void test() {
        System.out.println(countArrangement(1));
    }

    private int count;

    public int countArrangement(int n) {
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        helper(array, 0);
        return count;
    }

    private void helper(int[] array, int i) {
        if (i == array.length - 1) {
            if (isOk(array[i], i + 1)) {
                System.out.println(Arrays.toString(array));
                count++;
            }
        } else {
            for (int j = i; j < array.length; j++) {
                if (isOk(array[j], i + 1)) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    helper(array, i + 1);

                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    public boolean isOk(int a, int b) {
        if (a % b == 0 || b % a == 0) {
            return true;
        }
        return false;
    }
}
