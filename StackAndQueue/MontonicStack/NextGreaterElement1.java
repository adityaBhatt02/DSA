/*
There are two arrays:
nums1 = the numbers you are ASKING about
nums2 = the array where you SEARCH for the next greater element

Example
nums1 = [4, 1, 2]
nums2 = [1, 3, 4, 2]
For every number in nums1, go find that same number inside nums2.

Then ask: Starting immediately to its right in nums2, what is the first number bigger than it?

Query 1: 4

Find 4 in nums2:
[1, 3, 4, 2]
       ↑
Look to the right:

[1, 3, 4, 2]
          ↑
Only 2.

Is 2 > 4?
false
There is nothing else to the right.
So: 4 → -1

Query 2: 1

Find 1:
[1, 3, 4, 2]
 ↑
Look right:

3 → 4 → 2
The first one greater than 1 is: 3
So: 1 → 3


Query 3: 2

Find 2:
[1, 3, 4, 2]
          ↑
Nothing is to its right.

So: 2 → -1
Therefore: nums1 = [4,1,2]

answer = [-1,3,-1]
 */

public class NextGreaterElement {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        /*
            Why are we processing nums2 from right to left?
            The question asks: Find the first greater element to the right.
            So if we're currently looking at: [1, 3, 4, 2]

            and we're at 4, we need information about what's to its right.
            Processing from right → left means that when we reach 4, we've already processed: 2
            So the stack contains useful information about the right side.
         */
        for(int i = nums2.length - 1; i >= 0; i--) {
            int current = nums2[i];

            while(!stack.isEmpty() && stack.peek() <= current) stack.pop();  // Remove everything that cannot possibly be the next greater element. After removing those useless elements, the top of the stack is the closest useful greater element.

            if(stack.isEmpty()) {
                map.put(current, -1);
            } else {
                map.put(current, stack.peek());
            }

            stack.add(current);
        }

        int[] result = new int[nums1.length];
        for(int i = 0; i < result.length; i++) result[i] = map.get(nums1[i]);

        return result;
    }
}