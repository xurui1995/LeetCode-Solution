package javacode;

public class Solution1718_LexiLargestVaildSequence {
    public int[] constructDistancedSequence(int n) {
        int[] array = new int[2 * (n - 1) + 1];
        boolean[] flags = new boolean[n + 1];
        dfs(array, 0, flags);
        return array;
    }

    public boolean dfs(int[] array, int index, boolean[] flags) {

        if (index == array.length) {
            return true;
        }

        if (array[index] == 0) {
            for (int i = flags.length - 1; i >= 1; i--) {
                int j = index + (i == 1 ? 0 : i);
                if (!flags[i] && j < array.length && array[j] == 0) {
                    flags[i] = true;
                    array[index] = i;
                    array[j] = i;

                    if (dfs(array, index + 1, flags)) {
                        return true;
                    }

                    array[index] = 0;
                    array[j] = 0;
                    flags[i] = false;
                }
            }
        } else {
            return dfs(array, index + 1, flags);
        }
        return false;
    }
}
