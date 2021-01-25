package javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution90_SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        ans.add(new ArrayList());
        List<Integer> list = new ArrayList();
        dfs(ans, nums, list, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        if (index == nums.length) {
            return;
        } else {
            list.add(nums[index]);
            ans.add(new ArrayList(list));

            dfs(ans, nums, list, index + 1);

            list.remove(list.size() - 1);
            int i = index + 1;
            while (i < nums.length && nums[i] == nums[index]) {
                i++;
            }
            dfs(ans, nums, list, i);
        }
    }
}
