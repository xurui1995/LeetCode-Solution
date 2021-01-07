package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1414_FindMinFibonacciSumIsK {

    @Test
    public void test() {
        System.out.println(findMinFibonacciNumbers(7));
        System.out.println(findMinFibonacciNumbers(10));
        System.out.println(findMinFibonacciNumbers(19));
        System.out.println(findMinFibonacciNumbers(4));
        System.out.println(findMinFibonacciNumbers(1));
        System.out.println(findMinFibonacciNumbers(3));
    }

    public int findMinFibonacciNumbers(int k) {
        int f1 = 1;
        int f2 = 2;
        int temp = f1 + f2;
        while (temp <= k) {
            f1 = f2;
            f2 = temp;
            temp = f1 + f2;
            if (temp == k) {
                return 1;
            }
        }
        int ans = 0;
        while (k != 0) {
            while (f2 > k) {
                temp = f2 - f1;
                f2 = f1;
                f1 = temp;
            }
            k = k - f2;
            ans++;
        }
        return ans;
    }

}
