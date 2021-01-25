package javacode;

import org.junit.Test;

import java.util.HashMap;

public class Solution560_SubarraySumEqualsK {
    @Test
    public void test() {
        System.out.println(subarraySum(new int[]{-1, -1, 1}, 1));
    }

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int ans = map.getOrDefault(k, 0);

        temp = 0;
        for (int i = 0; i < nums.length; i++) {
            temp += nums[i];
            int value = map.getOrDefault(temp + k, 0);
            ans += value;
            if (k == 0) {
                ans--;
            }
            map.put(temp, map.getOrDefault(temp, 0) - 1);
        }
        return ans;
    }
}
