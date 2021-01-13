package javacode;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1046_LastStoneWeight {

    @Test
    public void test() {
        int[] a = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(a));
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < stones.length; i++) {
            queue.offer(stones[i]);
        }

        while (queue.size() >= 2) {
            int value1 = queue.poll();
            int value2 = queue.poll();
            if (Math.abs(value1 - value2) != 0) {
                queue.offer(Math.abs(value1 - value2));
            }
        }
        if (queue.size() == 1) {
            return queue.poll();
        }
        return 0;
    }
}
