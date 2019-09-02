import org.junit.Test;

class Solution190 {

    @Test
    public static void main(String[] args) {
        System.out.println(new Solution190().reverseBits(-3));
        System.out.println(new Solution190().reverseBits(1));
        System.out.println(new Solution190().reverseBits(1431655765));
    }

    public int reverseBits(int n) {
        int[] array = new int[32];
        for (int i = 0; i < 32; i++) {
            array[i] = (n >> i) & 1;
        }
        int ans = 0;
        if (array[0] == 0) {
            for (int i = 31; i > 0; i--) {
                if (array[i] == 1) {
                    ans += 1 << (31 - i);
                }
            }
        } else {
            int index = -1;
            for (int i = 31; i > 0; i--) {
                if (array[i] == 0 && index == -1) {
                    continue;
                }
                if (array[i] == 1 && index == -1) {
                    array[i] = 0;
                    index = i;
                }
                if (array[i] == 0) {
                    ans -= 1 << (31 - i);
                }
            }

            if (index == -1) {
                ans = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}


