package javacode;

import org.junit.Test;

import java.util.HashMap;

public class Solution1658_MinOperationReduceToZero {

    @Test
    public void test() {
        System.out.println(minOperations(new int[]{8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309}, 134365));
    }

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int ans = Integer.MIN_VALUE;
        int target = sum - x;
        if (target == 0) {
            return nums.length;
        }
        sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) {
                ans = Math.max(i + 1, ans);
            } else {
                if (map.containsKey(sum - target)) {
                    ans = Math.max(i - map.get(sum - target), ans);
                }
            }
            map.put(sum, i);
        }

        if (ans != Integer.MIN_VALUE) {
            return nums.length - ans;
        }
        return -1;
    }
}
