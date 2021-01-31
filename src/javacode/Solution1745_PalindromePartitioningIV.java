package javacode;

public class Solution1745_PalindromePartitioningIV {
    public boolean checkPartitioning(String s) {
        boolean[][] flags = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int start = i;
            int end = i;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                flags[start][end] = true;
                start--;
                end++;
            }

            start = i;
            end = i + 1;
            while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
                flags[start][end] = true;
                start--;
                end++;
            }
        }
        return dfs(s, 0, 0, flags);
    }

    public boolean dfs(String s, int index, int count, boolean[][] flags) {
        if (index >= s.length()) {
            return false;
        }
        if (count == 2) {
            return flags[index][s.length() - 1];
        } else {
            for (int i = index; i <= s.length() - 1; i++) {
                if (flags[index][i] && dfs(s, i + 1, count + 1, flags)) {
                    return true;
                }
            }
            return false;
        }
    }
}
