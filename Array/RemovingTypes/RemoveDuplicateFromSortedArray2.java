package Array.RemovingTypes;

/*
Same like RemoveDuplicateFromSortedArray but here we can have 2 duplicates of an element(if any).
eg : [1,1,1,2,2,3]
o/p -> 5  , [1,1,2,2,3,_]
 */
public class RemoveDuplicateFromSortedArray2 {
    public int removeDuplicate(int[] nums) {
        if(nums.length <= 2) return nums.length;

        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[k - 2]){
                nums[k] = nums[i];
                k++;
        }}
        return k;
    }
}
