package StackAndQueue;

import java.util.Stack;

public class QueueUsingStack {

        private Stack<Integer> stack1; // Main stack for pushing elements
        private Stack<Integer> stack2; // Helper stack for reversing order

        public QueueUsingStack() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        // Push element to the back of the queue
        public void push(int x) {
            stack1.push(x);
        }

        // Removes the element from the front of the queue
        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop()); // Reverse order of stack1 into stack2
                }
            }
            return stack2.pop(); // Pop from stack2 (front of queue)
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
}
