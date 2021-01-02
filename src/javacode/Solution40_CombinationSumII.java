package javacode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution40_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        Arrays.sort(candidates);
        helper(results, stack, candidates, target, 0);
        return results;
    }

    private void helper(List<List<Integer>> results, LinkedList<Integer> temp, int[] candidates, int target, int index) {
        if (index >= candidates.length) {
            return;
        }

        if (candidates[index] > target) {
            helper(results, temp, candidates, target, index + 1);
        } else if (candidates[index] == target) {
            temp.push(candidates[index]);
            results.add(new ArrayList<>(temp));
            temp.pop();
            while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) {
                index++;
            }
            helper(results, temp, candidates, target, index + 1);
        } else {
            temp.push(candidates[index]);
            helper(results, temp, candidates, target - candidates[index], index + 1);
            temp.pop();

            while (index + 1 < candidates.length && candidates[index + 1] == candidates[index]) {
                index++;
            }
            helper(results, temp, candidates, target, index + 1);
        }
    }
}
