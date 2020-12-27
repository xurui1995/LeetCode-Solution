package javacode;

import org.junit.Test;

public class Solution367_ValidPerfectSquare {

    @Test
    public void test() {
        System.out.println(isPerfectSquare(808201));
    }

    public boolean isPerfectSquare(int num) {
        int start = 0;
        int end = num;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int value = mid * mid;
            if (value / mid != mid) {
                end = mid;
                continue;
            }
            if (value == num) {
                return true;
            } else if (value > num) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return start * start == num || end * end == num;
    }

}
