package javacode;

import org.junit.Test;

public class Solution540_SingleElementInSortedArray {

    @Test
    public void test() {
        System.out.println(singleNonDuplicate(new int[]{0, 1, 1}));
    }

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid + 1] && nums[mid] > nums[mid - 1]) {
                return nums[mid];
            } else if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])
                    || (mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                start = mid;
            } else {
                end = mid;
            }
        }

        int before = -1;
        if (end > 0) {
            before = nums[end - 1];
        }
        int after = -1;
        if (end < nums.length - 1) {
            after = nums[end + 1];
        }
        if (nums[end] != before && nums[end] != after) {
            return nums[end];
        }
        return nums[start];
    }
}
