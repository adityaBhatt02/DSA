package Array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0 , r = height.length - 1 , ans = 0;

        while(l < r) {
            int width = r - l;
            int heighT = Math.min(height[l] , height[r]);
            int waterContains = width * heighT;      // basically area of the container

            ans = Math.max(ans , waterContains);

            if(height[l] < height[r]) {
                l++;
            }else {
                r--;
            }
        }
        return ans;
    }
}
