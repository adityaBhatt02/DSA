package StackAndQueue;

import java.util.Stack;

/* this is called monotonic -
 A monotonic stack is a special data structure used in algorithmic problem-solving. Monotonic Stack maintaining elements in either
increasing or decreasing order. It is commonly used to efficiently solve problems such as finding the next greater or smaller element in an
array etc.
there are two types of monotonic stacks - 1) monotonic increasing stack and 2) monotonic decreasing stack ........
so in this question we used monotonic decreasing stack as jaise he greatest mil rha hae saare chote hta de rhe hae.
 */
public class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = n - 1; i >= 0; i--) {

            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
            
            if(!stack.isEmpty()) result[i] = stack.peek() - i;
            stack.push(i);
        }
        return result;
    }
}
