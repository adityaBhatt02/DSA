/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack("", n, 0, 0, result);
        return result;
    }

    private void backtrack(String currentString, int n, int open, int close, List<String> result) {
        if(currentString.length() >= n * 2) {         // a valid parenthesis with n number of open brackets will have n * 2 length
            result.add(currentString);
            return;
        }

        if(open < n) backtrack(currentString + "(", n, open + 1, close, result);

        if(close < open) backtrack(currentString + ")", n, open, close + 1, result);
    }
}