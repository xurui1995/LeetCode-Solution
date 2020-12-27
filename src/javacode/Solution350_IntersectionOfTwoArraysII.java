package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution350_IntersectionOfTwoArraysII {

    @Test
    public void test() {
        int[] ans = intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] temp = null;
        if (nums1.length > nums2.length) {
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int i = 0; i < nums1.length; i++) {
            int nums = map.getOrDefault(nums1[i], 0);
            map.put(nums1[i], nums + 1);
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            int nums = map.getOrDefault(nums2[i], 0);
            if (nums > 0) {
                list.add(nums2[i]);
            }
            map.put(nums2[i], nums - 1);
        }

        int[] array = new int[list.size()];
        int i = 0;
        for (int num : list) {
            array[i] = num;
            i++;
        }
        return array;
    }

}
