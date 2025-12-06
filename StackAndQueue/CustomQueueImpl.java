package StackAndQueue;

public class CustomQueueImpl {
        private static final int SIZE = 100;
        private final int[] queue = new int[SIZE];
        private int front = -1, rear = -1;

        // Enqueue operation
        public void enqueue(int value) {
            if (rear == SIZE - 1) {
                System.out.println("Queue Overflow");
                return;
            }
            if (front == -1) {
                front = 0; // First insertion
            }
            queue[++rear] = value;
            System.out.println(value + " enqueued");
        }

        // Dequeue operation
        public int dequeue() {
            if (front == -1 || front > rear) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return queue[front++];
        }

        // Peek front element
        public int peek() {
            if (front == -1 || front > rear) {
                System.out.println("Queue is empty");
                return -1;
            }
            return queue[front];
        }

        // Display queue
        public void display() {
            if (front == -1 || front > rear) {
                System.out.println("Queue is empty");
                return;
            }
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }

        // Main function to test the queue
        public static void main(String[] args) {
            CustomQueueImpl q = new CustomQueueImpl();

            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);
            q.display();

            System.out.println("Front element: " + q.peek());

            System.out.println("Dequeued: " + q.dequeue());
            q.display();
        }
    }
