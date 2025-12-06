package Array;

// 0 , 1 , 2 ko sort krna hae.
public class SortColors {
        public void sortColors(int[] nums) {
            /*
            low is for 0's , mid is for 1's and high is for 2's so when nums[mid] is 0 swap it with low and increase low , if
            nums[mid] is 1 its correct increase the mid only and then when nums[mid] is 2 swap it with high lower high
             */
            int low = 0 , mid = 0 , high = nums.length - 1;

            while(mid <= high) {
                if(nums[mid] == 0) {
                    swap(nums , low , mid);
                    low++;
                    mid++;
                }else if(nums[mid] == 1) {
                    mid++;
                }else {                      // if nums[mid] = 2
                    swap(nums , mid , high);
                    high--;
                }
            }
        }

        public void swap(int[] nums , int a , int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }
