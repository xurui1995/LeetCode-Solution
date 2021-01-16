package javacode;

import org.junit.Test;

public class Solution1248_CountNumberOfNcieSubarrays {

    @Test
    public void test() {
        int[] a = {2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        numberOfSubarrays(a, 2);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int counts = 0;
        int ans = 0;
        int i = 0;
        int j = 0;
        int zeros = 0;
        while (j < nums.length) {
            if (nums[j] % 2 == 1) {
                counts++;
            }
            if (counts == k) {
                if (j < nums.length - 1 && nums[j + 1] % 2 == 0) {
                    zeros++;
                } else {
                    int before = 0;
                    while (i <= j && nums[i] % 2 == 0) {
                        i++;
                        before++;
                    }
                    ans += (before + 1) * (zeros + 1);
                    i++;
                    zeros = 0;
                    counts--;
                }
            }
            j++;
        }
        return ans;
    }
}
