/*
same approach as MajorityElementI but more extended becz there was the rule that majority element is that which has occured more than n/2 times so the majority element is only one and it
was also stated that majority element will be in the array always.
But here there can be multiple majority elements (the rule here is majority element are those which occurs more than n/3 times and (so in n/3 its like atmost 2 elements but there can be only
one or none too) in this question there is no gurantee that majority element will be there or not so thats why we have verification code at the end.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
*/

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for(int num : nums) {
            if(candidate1 == num) {
                count1++;
            }else if(candidate2 == num) {
                count2++;
            }else if(count1 == 0) {
                candidate1 = num;
                count1 = 1;
            }else if(count2 == 0) {
                candidate2 = num;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }

      // verification
        count1 = 0;
        count2 = 0;
        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            } else if(num == candidate2){
                count2++;
            } 
        }

        List<Integer> result = new ArrayList<>();
        
        if(count1 > nums.length/3) result.add(candidate1);
        if(count2 > nums.length/3) result.add(candidate2);

        return result;
    }
}
