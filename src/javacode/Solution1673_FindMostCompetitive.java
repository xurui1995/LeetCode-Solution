package javacode;

import java.util.Stack;

public class Solution1673_FindMostCompetitive {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack();
        int[] ans = new int[k];
        int i = 0;

        while (i < nums.length) {
            if (stack.size() < k && (stack.isEmpty() || nums[i] >= stack.peek())) {
                stack.push(nums[i]);
            } else if (nums[i] < stack.peek()) {
                while (!stack.isEmpty() && nums[i] < stack.peek()) {
                    if (stack.size() + nums.length - i == k) {
                        break;
                    }
                    stack.pop();
                }
                stack.push(nums[i]);
            }
            i++;
        }

        i = k - 1;

        while (!stack.isEmpty()) {
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }
}
