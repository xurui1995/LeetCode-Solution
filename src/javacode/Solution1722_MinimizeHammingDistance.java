package javacode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Solution1722_MinimizeHammingDistance {

    @Test
    public void test() {
        int[] source = new int[]{5, 1, 2, 4, 3};
        int[] target = new int[]{1, 5, 4, 2, 3};
        int[][] allow = new int[][]{
                {0, 4},
                {4, 2},
                {1, 3},
                {1, 4}
        };
        System.out.println(minimumHammingDistance(source, target, allow));
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int ans = 0;

        UnionFind unionFind = new UnionFind(n);
        for (int[] swaps : allowedSwaps) {
            unionFind.union(swaps[0], swaps[1]);
        }

        Map<Integer, HashMap<Integer, Integer>> mutiMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = unionFind.find(i);
            if (mutiMap.containsKey(x)) {
                HashMap<Integer, Integer> map = mutiMap.get(x);
                map.put(source[i], map.getOrDefault(source[i], 0) + 1);
            } else {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(source[i], 1);
                mutiMap.put(x, map);
            }
        }

        for (int i = 0; i < n; i++) {
            int x = unionFind.find(i);
            HashMap<Integer, Integer> map = mutiMap.get(x);
            if (map.getOrDefault(target[i], 0) == 0) {
                ans++;
            } else {
                map.put(target[i], map.getOrDefault(target[i], 0) - 1);
            }
        }

        return ans;
    }
}

class UnionFind {
    int[] father;
    int[] weights;

    public UnionFind(int n) {
        father = new int[n];
        weights = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
            weights[i] = 1;
        }
    }

    public int find(int x) {
        if (father[x] != x) {
            return find(father[x]);
        }
        return x;
    }

    public void union(int x, int y) {
        int fatherX = find(x);
        int fatherY = find(y);
        if (fatherX != fatherY) {

            if (weights[fatherX] > weights[fatherY]) {
                weights[fatherX] += weights[fatherY];
                father[fatherY] = fatherX;
            } else {
                weights[fatherY] += weights[fatherX];
                father[fatherX] = fatherY;
            }
        }
    }
}
