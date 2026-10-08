package Array;

/*
->We place two pointers at the left (l) and right (r) ends of the array, keeping track of the maximum walls seen so far from both sides (lMax, rMax).
->Water trapped at any point depends on the smaller of lMax and rMax (because water spills over the lower side).
->If lMax < rMax, then the trapped water at l = lMax - height[l], and we move l rightward (since the left side is limiting).
->Otherwise, trapped water at r = rMax - height[r], and we move r leftward (since the right side is limiting).

Repeat until l and r meet, summing trapped water.

## That’s the intuitive explanation: always move the side with the smaller max, because that’s the bottleneck for storing water.

 */

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};
        System.out.print(trap(height));
    }

    private static int trap(int[] height) {
        int ans = 0 , l = 0 , r = height.length - 1 , leftMax = 0 , rightMax = 0;

        while(l < r) {
            leftMax = Math.max(leftMax , height[l]);
            rightMax = Math.max(rightMax , height[r]);

            if(leftMax < rightMax) {
                ans += leftMax - height[l];
                l++;
            }else {
                ans += rightMax - height[r];
                r--;
            }
        }
        return ans;
    }
}
