/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith
line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water
(blue section) the container can contain is 49.


Example 2:
Input: height = [1,1]
Output: 1
 */

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, result = 0;

        while(left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int area = Math.min(leftHeight, rightHeight) * (right - left);                         // leftHeight or rightHeight and the main height of the area will be the minHeight
            result = Math.max(result, area);

            /*
            The shorter wall is the bottleneck, so we move the shorter wall hoping to find a taller one.
                            left is shorter  → move left
                            right is shorter → move right
            Because only replacing the shorter wall gives us a chance to increase the limiting height.
             */
            if(leftHeight < rightHeight) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}

/*
width = rightIndex - leftIndex (not +1 becz it will count boundaries too and not -1 becz it will count number of element inside the boundary
We need actual physical distance b/w the boundaries thats why only r - l)
*/