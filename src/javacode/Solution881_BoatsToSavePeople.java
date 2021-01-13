package javacode;

public class Solution881_BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        int[] array = new int[limit + 1];
        for (int i = 0; i < people.length; i++) {
            array[people[i]]++;
        }

        int i = 0;
        int j = limit;
        int ans = 0;
        while (i < j) {
            while (i < j && array[i] == 0) {
                i++;
            }
            while (i < j && array[j] == 0) {
                j--;
            }
            if (i >= j) {
                break;
            }

            if (i + j <= limit) {
                ans++;
                array[i]--;
                array[j]--;
            } else {
                ans += array[j];
                j--;
            }
        }
        if (array[i] != 0) {
            if (i <= limit / 2) {
                ans += (array[i] + 1) / 2;
            } else {
                ans += array[i];
            }
        }
        return ans;
    }
}
