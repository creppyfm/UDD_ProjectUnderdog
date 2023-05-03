package LC;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> solutionList = new ArrayList<>();
        dfs(solutionList, 0, 0, n, "");

        return solutionList;
    }

    private void dfs(List<String> solutionList, int left, int right, int n, String string) {
        if (string.length() == (n * 2) && !solutionList.contains(string)) {
            solutionList.add(string);
            return;
        }

        if (left < n) {
            dfs(solutionList, left + 1, right, n, string + "(");
        }

        if (right < left) {
            dfs(solutionList, left, right + 1, n, string + ")");
        }
    }
}
