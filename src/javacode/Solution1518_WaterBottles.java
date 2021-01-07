package javacode;

import org.junit.Test;

public class Solution1518_WaterBottles {

    @Test
    public void test() {
        System.out.println(numWaterBottles(15, 4));
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int leftBottles = 0;
        while ((numBottles + leftBottles) / numExchange != 0) {
            ans += numBottles;
            int total = numBottles + leftBottles;
            numBottles = total / numExchange;
            leftBottles = total % numExchange;
        }
        ans += numBottles;
        return ans;
    }
}
