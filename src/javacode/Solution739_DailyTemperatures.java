package javacode;

import java.util.Stack;

public class Solution739_DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        Stack<int[]> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < T[i]) {
                ans[stack.peek()[0]] = i - stack.peek()[0];
                stack.pop();
            }
            stack.push(new int[]{i, T[i]});
        }
        return ans;
    }
}
