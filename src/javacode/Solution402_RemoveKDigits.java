package javacode;

import org.junit.Test;

public class Solution402_RemoveKDigits {

    @Test
    public void test() {
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("1234", 2));
        System.out.println(removeKdigits("10", 2));
    }


    public String removeKdigits(String num, int k) {

        StringBuilder ans = new StringBuilder();
        outer:
        for (int i = 0; i < num.length(); i++) {
            if (i == 0) {
                ans.append(num.charAt(i));
            } else if (num.charAt(i) >= num.charAt(i - 1)) {
                ans.append(num.charAt(i));
            } else {
                int j = ans.length() - 1;
                while (j >= 0) {
                    if (ans.charAt(j) > num.charAt(i)) {
                        k--;
                        ans.deleteCharAt(j);
                        if (k == 0) {
                            ans.append(num.substring(i));
                            break outer;
                        }
                    } else {
                        break;
                    }
                    j--;
                }
                ans.append(num.charAt(i));
            }
        }
        if (k > 0) {
            ans.delete(ans.length() - k, ans.length());
        }
        while (ans.length() > 1 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        if (ans.length() == 0) {
            return "0";
        }
        return ans.toString();
    }
}
