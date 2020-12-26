package javacode;

import org.junit.Test;

public class Solution14_LongestCommonPrefix {

    @Test
    public void test() {
        longestCommonPrefix(new String[]{""});
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String minStr = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < minStr.length()) {
                minStr = strs[i];
            }
        }
        if (minStr.isEmpty()) {
            return "";
        }

        int start = 0;
        int end = minStr.length() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isCommon(strs, start, mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (isCommon(strs, 0, start)) {
            if (isCommon(strs, start, end)) {
                return minStr.substring(0, end + 1);
            }
            return minStr.substring(0, start + 1);
        }

        return "";
    }

    private boolean isCommon(String[] strs, int start, int end) {
        for (int i = start; i <= end; i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != temp) {
                    return false;
                }
            }
        }
        return true;
    }
}
