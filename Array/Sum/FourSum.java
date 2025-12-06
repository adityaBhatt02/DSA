package Array.Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
same like 3sum but in this we need quadruplets so the idea is same like i is constant and all but in this there are 2 people that are constant one is ofco i and other is j
(j is like constant for one iteration like it is same as i in 3sum) so yeah now there are 2 for loops rest is same.
we have to check for duplicates for j also (becz its like i was in 3sum).
 */

public class FourSum {
    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2};
        int target = 0;

        System.out.println(sum4(arr , target));
    }

    static List<List<Integer>> sum4(int[] nums , int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;           // skip duplicate i

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;    // skip duplicate j

                int k = j + 1 , l = nums.length - 1;

                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i] , nums[j] , nums[k] , nums[l]));

                        while (k < l && nums[k] == nums[k+1]) k++;           // skip duplicate k
                        while (k < l && nums[l] == nums[l-1]) l--;           // skip duplicate l

                        k++;
                        l--;
                    }else if(sum < target) {
                        k++;
                    }else {
                        l--;
                    }
                }

            }

        }
        return result;
    }

}