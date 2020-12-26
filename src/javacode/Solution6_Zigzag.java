package javacode;

import org.junit.Test;

public class Solution6_Zigzag {

    @Test
    public void test() {
        System.out.println(convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int gap = numRows * 2 - 2;
        for (int i = 0; i < numRows; i++) {
            if (i == 0 || i == numRows - 1) {
                int j = i;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += gap;
                }
            } else {
                for (int j = 0; j + i < s.length(); j += gap) {
                    sb.append(s.charAt(j + i));
                    if (j + gap - i < s.length()) {
                        sb.append(s.charAt(j + gap - i));
                    }
                }

            }
        }
        return sb.toString();
    }

}
