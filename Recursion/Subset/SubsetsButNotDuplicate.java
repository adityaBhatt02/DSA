package Recursion.Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Given an integer array nums that may contain duplicates, return all possible subsets (the power set). {but subsets should not be duplicate}

sort isliye krte hae ->
[2,1,2] hae jaise so agr sort nhi krenge then pichle waale se check krenge then duplicate nhi milega
but if we sort then it will be [1,2,2] then piche waale se check krenge if its equal or not then 2 is equal to 2 then just skip it.
 */

public class SubsetsButNotDuplicate {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);                // sort kra becz duplicates ke liye kaam krta hae
            subset(0 , nums , new ArrayList<>() , result);
            return result;
        }

        private void subset(int index , int[] nums , List<Integer> current , List<List<Integer>> result) {
            result.add(new ArrayList<>(current));

            for(int i = index ; i < nums.length ; i++) {

                if (i > index && nums[i] == nums[i - 1]) continue;    // skip duplicates (if i index se bada hoga and nums[i] ke value if equal hae peeeche waale se then its a duplicate so skip it

                current.add(nums[i]);
                subset(i + 1 , nums , current , result);
                current.removeLast();
            }
        }
}
