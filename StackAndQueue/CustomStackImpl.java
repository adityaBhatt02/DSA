package StackAndQueue;

public class CustomStackImpl {
    private static final int DEFAULT_VALUE = 10;
    int[] data;
    int ptr = -1;

    CustomStackImpl() {
        this.data = new int[DEFAULT_VALUE];
    }
    CustomStackImpl(int size) {
        this.data = new int[size];
    }

    void push(int val) throws Exception {
        if (isFull()) {
            throw new Exception("Stack is full!");
        }
        data[++ptr] = val;
    }

    int pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        int removed = data[ptr];
        ptr--;
        return removed;
    }

    int peek() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        return data[ptr];
    }

    void display() throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty!");
        }
        for (int i = 0; i <= ptr; i++) {
            System.out.println(data[i]);
        }
    }

    boolean isFull() {
        return ptr == data.length-1;
    }
    boolean isEmpty() {
        return ptr < 0;
    }


    public static void main(String[] args) throws Exception {
        CustomStackImpl stack = new CustomStackImpl();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        stack.display();
        System.out.println();

        stack.pop();
        stack.pop();

        stack.display();
        System.out.println();

        System.out.println(stack.peek());
    }
}
