package javacode;

import org.junit.Test;

public class Solution441_ArrangingCoins {

    @Test
    public void test() {
        System.out.println(arrangeCoins(1804289383));
    }

    public int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8.0 * n)) / 2);
    }
}
