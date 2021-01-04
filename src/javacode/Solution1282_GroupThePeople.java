package javacode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1282_GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                List<Integer> list = map.get(groupSizes[i]);
                list.add(i);
                if (list.size() == groupSizes[i]) {
                    ans.add(list);
                    map.remove(groupSizes[i]);
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                if (groupSizes[i] == 1) {
                    ans.add(list);
                } else {
                    map.put(groupSizes[i], list);
                }
            }
        }
        return ans;
    }
}
