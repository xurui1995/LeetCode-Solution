package javacode.binarysearch;

import org.junit.Test;


public class Solution33 {

    @Test
    public void test() {
        int[] nums = {5, 1, 3};
        System.out.println(search(nums, 3));
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums2, 0));
    }

    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                if (target < nums[0] && nums[mid] >= nums[0]) {
                    i = mid;
                } else {
                    j = mid;
                }
            } else {

                if (target >= nums[0] && nums[mid] < nums[0]) {
                    j = mid;
                } else {
                    i = mid;
                }
            }
        }
        if (nums[i] == target) {
            return i;
        }
        if (nums[j] == target) {
            return j;
        }
        return -1;
    }
}
