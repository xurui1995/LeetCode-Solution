package javacode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1306_JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        set.add(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index - arr[index] >= 0 && !set.contains(index - arr[index])) {
                if (arr[index - arr[index]] == 0) {
                    return true;
                }
                set.add(index - arr[index]);
                queue.offer(index - arr[index]);
            }
            if (index + arr[index] < arr.length && !set.contains(index + arr[index])) {
                if (arr[index + arr[index]] == 0) {
                    return true;
                }
                set.add(index + arr[index]);
                queue.offer(index + arr[index]);
            }
        }
        return false;
    }

    private boolean addToSet(HashSet<Integer> set, int[] arr, int start) {
        if (start < 0 || start > arr.length - 1) {
            return false;
        }
        if (set.contains(start)) {
            return false;
        }
        if (arr[start] == 0) {
            return true;
        }
        set.add(start);
        return addToSet(set, arr, start + arr[start]) || addToSet(set, arr, start - arr[start]);
    }

}

