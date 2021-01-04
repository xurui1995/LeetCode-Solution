package javacode;

import org.junit.Test;

import java.util.Arrays;

public class Solution31_NextPermutation {

    @Test
    public void test() {
//        nextPermutation(new int[]{1, 2, 3});
//        nextPermutation(new int[]{3, 2, 1});
//        nextPermutation(new int[]{1, 1, 5});
//        nextPermutation(new int[]{1});
        int[] nums = new int[]{1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i >= 0) {
            if (i - 1 >= 0 && nums[i] > nums[i - 1]) {
                break;
            }
            i--;
        }
        if (i == -1) {
            i = 0;
            int j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
                i++;
            }
        } else {
            int index = i - 1;
            int j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }

            for (int k = index + 1; k < nums.length; k++) {
                if (nums[k] > nums[index]) {
                    int temp = nums[index];
                    nums[index] = nums[k];
                    nums[k] = temp;
                    return;
                }
            }
        }
    }


}
