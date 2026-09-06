/*
Remove the Outermost parenthesis

Example 1:
Input: s = "(()())(())"
Output: "()()()"

Example 2:
Input: s = "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".

Example 3:
Input: s = "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".


Approach is simple its that first understand what depth is for eg we have this 
(()())(()) -> in this when we find the first '(' the depth is 1 meaning we are inside 1 pair and then we find the second '(' and then depth is 2 now means now we are 
inside 2 pair so every '(' increases the depth and every ')' decrease the depth and when depth is 0 again it means curently inside no opening pair.

Now the idea is simple we are managing that depth whenever we find '(' increase the depth always but when depth == 0 dont add that particular '(' in the result string
becz we need to remove outer paranthesis from the output string 
Similarly, when we find ')' decrease the depth and add to the output string but when depth == 0 dont add that particular ')' as its the outermost closing parenthesis.
*/

class RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                if(depth > 0) result.append(ch);
                depth++;
            } else {
                depth--;
                if(depth > 0) result.append(ch);
            }
        }
        return result.toString();
    }
}

