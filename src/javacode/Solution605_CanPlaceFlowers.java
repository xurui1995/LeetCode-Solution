package javacode;

public class Solution605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i += 2) {
            if (flowerbed[i] == 0) {
                if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                    n--;
                    if (n <= 0) {
                        break;
                    }
                } else {
                    i++;
                }
            }
        }
        return n <= 0;
    }
}
