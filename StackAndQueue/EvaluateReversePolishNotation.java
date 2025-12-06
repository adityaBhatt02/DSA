package StackAndQueue;
import java.util.Stack;

/*
ReversePolishNotation(RPN) states that if the element is a number then normally push it but if the element
is an operator then pop the last 2 inserted elements and then apply that operator to them and then push
the result back to the stack.

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9

operator can't come first like ["+" , "2" , "/" , "3"]
becz then it's not a valid RPN it will give error.
 */

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int result = 0;
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+" : result = a + b; break;
                    case "-" : result = a - b; break;
                    case "*" : result = a * b; break;
                    case "/" : result = a / b; break;
                }
                stack.push(result);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
