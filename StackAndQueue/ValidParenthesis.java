package StackAndQueue;

import java.util.Stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else {
                if(ch == ')') {
                    if(stack.isEmpty() || stack.pop() != '(') {        // is empty isliye check krte hae becz kya pta first element he ) ho then empty stack se pop kroge to error ayega and phla element agr wo hoga to false wiase bhi.
                        return false;
                    }
                }
                if(ch == '}') {
                    if(stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                }
                if(ch == ']') {
                    if(stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();           // if returned true directly then edge case like only a single bracket like [ is false but gets true so stack will be empty if its a valid parenthesis
    }
}
