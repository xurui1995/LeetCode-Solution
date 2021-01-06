package javacode;

public class Solution1539_KthMissingPositiveNumber {

    public int findKthPositive(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) {
                int gaps = arr[i] - 1;
                if (gaps >= k) {
                    return k;
                } else {
                    k = k - gaps;
                }
            } else if (arr[i] - arr[i - 1] != 1) {
                int gaps = arr[i] - arr[i - 1] - 1;
                if (gaps >= k) {
                    return arr[i - 1] + k;
                } else {
                    k = k - gaps;
                }
            }
        }

        return arr[arr.length - 1] + k;
    }
}
