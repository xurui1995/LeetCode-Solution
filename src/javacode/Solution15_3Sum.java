package javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15_3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int v = nums[start] + nums[end] + nums[i];
                if (v == 0) {
                    ans.add(Arrays.asList(nums[start], nums[end], nums[i]));
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                    while (start < end && nums[end - 1] == nums[end]) {
                        end--;
                    }
                    end--;
                } else if (v > 0) {
                    while (start < end && nums[end - 1] == nums[end]) {
                        end--;
                    }
                    end--;
                } else {
                    while (start < end && nums[start] == nums[start + 1]) {
                        start++;
                    }
                    start++;
                }
            }

        }
        return ans;
    }
}
