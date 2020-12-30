package javacode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution22_GenerateParenthesis {

    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        dfs(ans, stringBuilder, 0, 0, n);
        return ans;
    }

    public void dfs(List<String> ans, StringBuilder stringBuilder, int i, int j, int n) {
        if (i == 0) {
            stringBuilder.append("(");
            dfs(ans, stringBuilder, 1, 0, n);
        } else if (i == n && j == n) {
            ans.add(stringBuilder.toString());
        } else if (i == n) {
            stringBuilder.append(")");
            dfs(ans, stringBuilder, i, j + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        } else if (j > i) {
            return;
        } else {
            stringBuilder.append("(");
            dfs(ans, stringBuilder, i + 1, j, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);

            stringBuilder.append(")");
            dfs(ans, stringBuilder, i, j + 1, n);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
