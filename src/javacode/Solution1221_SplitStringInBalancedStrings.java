package javacode;

public class Solution1221_SplitStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int L_counts = 0;
        int R_counts = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                L_counts++;
            } else {
                R_counts++;
            }
            if (L_counts == R_counts && L_counts != 0) {
                ans++;
                L_counts = 0;
                R_counts = 0;
            }
        }
        return ans;
    }
}
