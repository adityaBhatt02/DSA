package Array;

/*
-> We place two pointers at the left (l) and right (r) ends of the array, keeping track of the maximum walls seen so far from
both sides (lMax, rMax).
-> Water trapped at any point depends on the smaller of lMax and rMax (because water spills over the lower side).
-> If lMax < rMax, then the trapped water at l = lMax - height[l], and we move l rightward (since the left side is limiting).
-> Otherwise, trapped water at r = rMax - height[r], and we move r leftward (since the right side is limiting).

Repeat until l and r meet, summing trapped water.

## That’s the intuitive explanation: always move the side with the smaller max, because that’s the bottleneck for storing
water.

 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, water = 0;

        while(left < right) {
            if(height[left] <= height[right]) {
                if(leftMax <= height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;
            } else {
                if(rightMax <= height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }
        return water;
    }
}

/*
Container With Most Water:
You choose two bars and calculate:          area = min(leftHeight, rightHeight) × width


Trapping Rain Water:
You consider every position and ask how much water that position can hold:
water = min(tallestLeft, tallestRight) - currentHeight

So don't think of this as one giant container.

Think:
Every low point can trap some amount of water between the tallest wall on its left and the tallest wall on its right.
 */