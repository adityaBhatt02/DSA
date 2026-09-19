/*
Given an array of integers arr, your task is to find the Next Smaller Element (NSE) for every element in the array.
The Next Smaller Element for an element x is defined as the first element to the right of x that is smaller than x.
If there is no smaller element to the right, then the NSE is -1.

Example 1
Input: arr = [4, 8, 5, 2, 25]
Output: [2, 5, 2, -1, -1]

Explanation:
- For 4, the next smaller element is 2.
- For 8, the next smaller element is 5.
- For 5, the next smaller element is 2.
- For 2, there is no smaller element to its right → -1.
- For 25, no smaller element exists → -1.

Example 2
Input: arr = [10, 9, 8, 7]
Output: [9, 8, 7, -1]

Explanation:
Each element’s next right neighbor is smaller.
 */

public class NextSmallerElement {
    public int[] nextSmallerElements(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) result[i] = -1;

        for(int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];

            while(!stack.isEmpty() && stack.peek() >= current) stack.pop();

            if(!stack.isEmpty()) result[i] = stack.peek();
            stack.push(current);
        }
        return result;
    }
}