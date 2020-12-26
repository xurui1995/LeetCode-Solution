package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution349_IntersectionOfTwoArrays {

    @Test
    public void test() {
        System.out.println(intersection(new int[]{1, 2, 3}, new int[]{3, 5}));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        HashSet<Integer> set = new HashSet<>();

        int[] temp = null;
        if (nums1.length > nums2.length) {
            temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }

        HashSet<Integer> set2 = new HashSet<>();

        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] array = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            array[i] = num;
            i++;
        }
        return array;
    }

}
