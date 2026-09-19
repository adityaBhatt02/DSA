/*
Next Greater Element II is the same monotonic-stack idea you just learned, with one new complication: the array is circular.

For example:

nums = [1, 2, 1]
For the last 1, you are allowed to continue from the beginning:

[1, 2, 1]
      ↑
      |
      └── then 1 → 2
So the answer is:

[2, -1, 2]
The new question is essentially:

After reaching the end of the array, pretend the array starts again.

For a normal array: [5, 1, 2, 3, 4]
4 has nothing to its right → -1.

For a circular array: [5, 1, 2, 3, 4]
then for 4: 4 → 5
so its next greater is 5.

The monotonic stack itself doesn't fundamentally change. The main challenge is figuring out how to make the array behave as if
it were traversed twice.
 */

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int n = nums.length;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) result[i] = -1;

        for(int i = n*2 - 1; i >= 0; i--) {
            int index = i % n;
            int current = nums[index];

            while(!stack.isEmpty() && stack.peek() <= current) stack.pop();

            if(!stack.isEmpty()) result[index] = stack.peek();

            stack.push(current);
        }
        return result;
    }
}