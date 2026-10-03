/*
You are given a sequence of integers arriving one at a time.
Design a data structure that supports the following operations:

FirstUniqueElement(int[] nums) -> Initialize the data structure with the given array of integers.

showFirstUnique() -> Return the first number in the sequence that currently appears exactly once.
If there is no such number, return -1.

add(int value) -> Add value to the sequence.

After adding it, the number may no longer be unique if it has appeared before.
 */

public class FirstUniqueElement {

    private Queue<Integer> queue;
    private HashMap<Integer, Integer> freq;

    public FirstUniqueElement(int[] nums) {
        queue = new LinkedList<>();
        freq = new HashMap<>();

        for (int num : nums) add(num);
    }

    public void add(int value) {
        freq.put(value, freq.getOrDefault(value, 0) + 1);

        // Only add to queue the first time we see it
        if (freq.get(value) == 1) queue.offer(value);
    }

    public int showFirstUnique() {

        // Remove numbers that are no longer unique
        while (!queue.isEmpty() && freq.get(queue.peek()) > 1) {
            queue.poll();
        }

        if (queue.isEmpty()) return -1;

        return queue.peek();
    }
}