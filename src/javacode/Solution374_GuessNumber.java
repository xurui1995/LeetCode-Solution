package javacode;

import org.junit.Test;

public class Solution374_GuessNumber {


    @Test
    public void test() {
        System.out.println(guessNumber(10));
    }

    public int guess(int num) {
        if (num == 6) {
            return 0;
        } else if (num > 6) {
            return -1;
        } else {
            return 1;
        }
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int value = guess(mid);
            if (value == 0) {
                return mid;
            } else if (value > 0) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (guess(start) == 0) {
            return start;
        }

        if (guess(end) == 0) {
            return end;
        }

        return -1;
    }


}
