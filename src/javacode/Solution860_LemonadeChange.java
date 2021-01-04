package javacode;

public class Solution860_LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int counts5 = 0;
        int counts10 = 0;
        for (int bill : bills) {
            if (bill == 5) {
                counts5++;
            } else if (bill == 10) {
                if (counts5 == 0) {
                    return false;
                }
                counts5--;
                counts10++;
            } else {
                if (counts10 > 0 && counts5 > 0) {
                    counts10--;
                    counts5--;
                } else if (counts5 >= 3) {
                    counts5 -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
