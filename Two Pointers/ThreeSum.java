package Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
approach is that "i" will be fixed and j will be i + 1 and k will be at last(nums.length - 1) then just check the sum of these three and then if it's less than 0
increase j or if it's more than 0 decrease k ( as we had sorted the array at the start so that the triplet that will be formed is sorted )  and yeah if j overlaps with k
it will destroy our order of sorting so that's why we loop till jb tk (j < k)
If the sum of triplets(i , j , k) is equal to the target then just add them into the list then as the target is reached now you have to increase j and decrease k at the same
time becz if you increase j as the array is sorted the sum will always be greater than the target as vice versa if we only decrease k. so while increasing decrease at the
same time we don't want duplicates so that's why we have to check if nums[j] == nums[j + 1] if yes skip it j++ vice versa for k.

And then when the loop ends for 0th index you have to check for i also for duplicates so for that if nums[i] == nums[i - 1] just skip this iteration.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};

        System.out.println(sum3(arr));
    }

    static List<List<Integer>> sum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums); // Step 1: Sort          -> [-4,-1,-1,0,1,2]

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicate i

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j] == nums[j + 1]) j++; // Skip duplicate j
                    while (j < k && nums[k] == nums[k - 1]) k--; // Skip duplicate k

                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}