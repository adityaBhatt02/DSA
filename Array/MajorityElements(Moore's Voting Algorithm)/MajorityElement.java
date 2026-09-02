/*
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:
Input: nums = [3,2,3]
Output: 3

Example 2:
Input: nums = [2,2,1,1,1,2,2]
Output: 2


1. Brute force — O(n²), O(1)
“First, I can check every element and count how many times it occurs using another loop. If its count is greater than n/2, that's the majority element.”
for (int i = 0; i < nums.length; i++) {
    int count = 0;

    for (int j = 0; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
            count++;
        }
    }
    if (count > nums.length / 2) {
        return nums[i];
    }
}

2. HashMap — O(n) time, O(n) space
Then you improve it:

“Instead of recounting every element, I can maintain its frequency in a HashMap while traversing the array.”

HashMap<Integer, Integer> map = new HashMap<>();

for (int num : nums) {
    map.put(num, map.getOrDefault(num, 0) + 1);

    if (map.get(num) > nums.length / 2) {
        return num;
    }
}

3. Moore's voting algo where candidate is the potential element i am taking as the majority element and count is like votes same elements vote that candidate( i.e, count++) and different 
element decrease the vote ( i.e, count--)
And most imp thing is that majority element is majority becz no one can cancel it fully becz it apprears more than n/2 times.
*/

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        for(int num : nums) {
            if(count == 0) candidate = num;

            if(num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
