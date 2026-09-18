/*
The cleanest approach is to use:

inStack → new elements go here
outStack → elements come out from here
 */

public class QueueUsingStack {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        moveIfNeeded();
        return outStack.pop();
    }

    public int peek() {
        moveIfNeeded();
        return outStack.peek();
    }

    public boolean empty() {
        moveIfNeeded();
        return outStack.isEmpty();
    }

    private void moveIfNeeded() {
        if(outStack.isEmpty()) {
            while(!inStack.isEmpty()) outStack.push(inStack.pop());
        }
    }
}