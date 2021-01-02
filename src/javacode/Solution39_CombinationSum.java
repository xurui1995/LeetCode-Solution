package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution39_CombinationSum {

    @Test
    public void test() {
        int[] a = {2, 7, 6, 3, 5, 1};
        int target = 9;
        List<List<Integer>> b = combinationSum(a, target);
        System.out.println(b);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
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

            helper(results, temp, candidates, target, index + 1);
        } else {
            temp.push(candidates[index]);
            helper(results, temp, candidates, target - candidates[index], index);
            temp.pop();

            helper(results, temp, candidates, target, index + 1);
        }
    }

}
