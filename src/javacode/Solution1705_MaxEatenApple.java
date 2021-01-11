package javacode;

import javafx.util.Pair;
import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1705_MaxEatenApple {

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 3, 5, 2};
        int[] b = new int[]{3, 2, 1, 4, 2};

        int[] c = new int[]{5, 2, 3};
        int[] d = new int[]{6, 9, 10};
        System.out.println(eatenApples(a, b));
        System.out.println(eatenApples(c, d));
    }

    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int ans = 0;

        for (int i = 0; i < apples.length; i++) {
            if (apples[i] > 0) {
                queue.offer(new int[]{i + days[i], apples[i],});
            }

            while (!queue.isEmpty() && queue.peek()[0] <= i) {
                queue.poll();
            }

            if (!queue.isEmpty()) {
                queue.peek()[1]--;
                ans++;
                if (queue.peek()[1] == 0) {
                    queue.poll();
                }
            }
        }

        int lastIndex = apples.length;
        int needMore = 0;

        while (!queue.isEmpty() && queue.peek()[0] <= lastIndex) {
            queue.poll();
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int gapDays = temp[0] - lastIndex;
            if (temp[1] > gapDays) {
                ans += gapDays;
                temp[1] = Math.min(needMore, temp[1] - gapDays);
                ans += temp[1];
                needMore = needMore - temp[1];
            } else {
                ans += temp[1];
                needMore += gapDays - temp[1];
            }

            lastIndex = temp[0];
        }
        return ans;
    }

}
