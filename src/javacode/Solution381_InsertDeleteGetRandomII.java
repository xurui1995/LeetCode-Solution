package javacode;

import org.junit.Test;

import java.util.*;

public class Solution381_InsertDeleteGetRandomII {

    @Test
    public void test() {
        RandomizedCollection randomizedCollection = new RandomizedCollection();
        randomizedCollection.insert(1);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.insert(1);
        randomizedCollection.insert(2);
        randomizedCollection.insert(2);
        randomizedCollection.remove(1);
        randomizedCollection.remove(2);
        randomizedCollection.remove(2);
        randomizedCollection.remove(2);
        randomizedCollection.getRandom();
    }

    class RandomizedCollection {
        HashMap<Integer, Set<Integer>> map;
        List<Integer> list;
        Random random = new Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean result = true;
            list.add(val);
            if (map.containsKey(val)) {
                result = false;
                map.get(val).add(list.size() - 1);
            } else {
                Set<Integer> temp = new HashSet<>();
                temp.add(list.size() - 1);
                map.put(val, temp);
            }
            return result;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            if (!map.containsKey(val) || map.get(val).isEmpty()) {
                return false;
            }

            Set<Integer> temp = map.get(val);
            int index = temp.iterator().next();
            int lastValue = list.get(list.size() - 1);

            list.set(index, lastValue);


            temp.remove(0);
            temp = map.get(lastValue);
            temp.add(index);
            temp.remove(list.size() - 1);
            list.remove(list.size() - 1);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
