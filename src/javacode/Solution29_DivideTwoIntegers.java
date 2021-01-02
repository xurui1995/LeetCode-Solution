package javacode;

import org.junit.Test;

public class Solution29_DivideTwoIntegers {

    @Test
    public void test() {
//        System.out.println(divide(7, -3));
//        System.out.println(divide(10, 3));
        System.out.println(divide(2147483647, 3));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == 1) {
            return dividend;
        }

        boolean sign = (divisor > 0) ^ (dividend > 0);
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) {
            divisor = -divisor;
        }

        if (dividend > divisor) {
            return 0;
        }
        int ans = 0;

        while (divisor >= dividend) {
            int x = 0;
            int temp = divisor << 1 << x;
            while (temp > dividend && temp < 0) {
                x++;
                temp = temp << 1;
//                System.out.println(divisor << 1 << x );
            }
            ans += 1 << x;
            dividend = dividend - (divisor << x);
        }

        return sign ? -ans : ans;
    }

}
