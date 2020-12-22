package javacode.binarysearch;

class Solution153 {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        if (nums[start] <= nums[end]) {
            return nums[start];
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[0]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}