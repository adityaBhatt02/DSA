package StackAndQueue;

import java.util.Stack;


// 1 normal stack and 1 min stack(min stack is used to store least values and the top of the min stack is the lowest element till now).
public class MinStack {
    private int minVal = Integer.MAX_VALUE;

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
    }

    public void push(int value) {
        if (value <= minVal) {     // duplicate handling, for eg if 2 is added multiple times in our normal stack but if it is not checking for = then in minstack multiple 2's will not be there 
            minVal = value;
            minStack.push(minVal);
        }

        stack.push(value);
    }

    public void pop() {
        int value = stack.pop();

        if (value == minVal) {
            minStack.pop();

            if (!minStack.isEmpty()) {
                minVal = minStack.peek();
            } else {
                minVal = Integer.MAX_VALUE;
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
