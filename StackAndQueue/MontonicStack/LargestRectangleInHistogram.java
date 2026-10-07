/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the
area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.


Example 2:
Input: heights = [2,4]
Output: 4




NSE should be n, not -1

You initialized:
NSE[i] = -1;
PSE[i] = -1;

PSE = -1 is correct because it means:
no smaller element to the left → boundary is just before index 0
But for NSE, when there is no smaller element to the right, the boundary should be: n
because n represents the position just after the last index.

For:
[2, 1, 5, 6, 2, 3]
take 3 at index 5.

There is no smaller element to its right.

So:
PSE[5] = 4
NSE[5] = 6

not:
NSE[5] = -1

Then:
width = 6 - 4 - 1  -->  1
which is correct.

If you use -1:

width = -1 - 4 - 1 --> -6
which is obviously wrong.

So initialize:
for (int i = 0; i < n; i++) {
    NSE[i] = n;
    PSE[i] = -1;
}
 */

// Using 2 stacks and 2 arrays { O(n) + O(n) + O(n) + O(n) = O(4n) --> O(n) }
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        Stack<Integer> stack1 = new Stack<>();              // nse
        Stack<Integer> stack2 = new Stack<>();              // pse

        int[] NSE = new int[n];
        int[] PSE = new int[n];
        for(int i = 0; i < heights.length; i++) {
            NSE[i] = n;
            PSE[i] = -1;              // no smaller element to the left → boundary is just before index 0
        }

        // for nse
        for(int i = n - 1; i >= 0; i--) {
            int current = heights[i];

            while(!stack1.isEmpty() && heights[stack1.peek()] >= current) stack1.pop();

            if(!stack1.isEmpty()) NSE[i] = stack1.peek();
            stack1.add(i);
        }

        // for pse
        for(int i = 0; i < n; i++) {
            int current = heights[i];

            while(!stack2.isEmpty() && heights[stack2.peek()] >= current) stack2.pop();

            if(!stack2.isEmpty()) PSE[i] = stack2.peek();
            stack2.add(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++) {
            int width = NSE[i] - PSE[i] - 1;    // when we do right - left + 1 it means including the boundaries for the length but right - left - 1 means only in b/w of right and left
            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}