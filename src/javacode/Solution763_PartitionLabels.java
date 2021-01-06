package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution763_PartitionLabels {

    @Test
    public void test() {
        System.out.println(partitionLabels("eabba"));
    }

    public List<Integer> partitionLabels(String S) {
        int[] endPos = new int[26];
        for (int i = 0; i < S.length(); i++) {
            endPos[S.charAt(i) - 'a'] = i;
        }

        List<Integer> ans = new ArrayList<>();
        int maxReach = 0;
        int lastIndex = 0;
        for (int i = 0; i < S.length(); i++) {
            int end = endPos[S.charAt(i) - 'a'];
            if (end == maxReach && i == maxReach) {
                ans.add(i - lastIndex + 1);
                lastIndex = i + 1;
                maxReach = maxReach + 1;
            } else if (end > maxReach) {
                maxReach = end;
                if (maxReach == S.length() - 1) {
                    ans.add(maxReach - lastIndex + 1);
                    break;
                }
            }
        }

        return ans;
    }


}
