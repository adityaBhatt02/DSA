/*
Given a valid parentheses string s, return the nesting depth of s. The nesting depth is the maximum number of nested parentheses.

Example 1:
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3

Example 2:
Input: s = "(1)+((2))+(((3)))"
Output: 3

Example 3:
Input: s = "()(())((()()))"
Output: 3
 */

public class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        int maxDepth = 0, currentDepth = 0;

        for(char c : s.toCharArray()) {
            if(c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            if(c == ')') currentDepth--;
        }
        return maxDepth;
    }
}