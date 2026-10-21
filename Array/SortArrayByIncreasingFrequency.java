/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values
have the same frequency, sort them in decreasing order.
Return the sorted array.

Example 1:
Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

Example 2:
Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.

Example 3:
Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]


Constraints:
1 <= nums.length <= 100
-100 <= nums[i] <= 100
 */

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        List<Integer> list = new ArrayList<>();
        for(int num : nums) list.add(num);

        Collections.sort(list, (a, b) -> {
            int value = Integer.compare(map.get(a), map.get(b));
            if(value == 0) return Integer.compare(b, a);   // frequencies same sort in descending order of values

            return value;
        });

        for(int i = 0; i < list.size(); i++) nums[i] = list.get(i);
        return nums;
    }
}