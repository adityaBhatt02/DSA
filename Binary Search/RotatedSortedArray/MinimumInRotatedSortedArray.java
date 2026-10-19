package BinarySearchQuestions.RotatedSortedArray;


/*
if nums = [10,13,14,15]          and you might think that largest element is 15 so it's the pivot and doing +1 of it will lead to outofbound exception.

but no pivotFunction will give -1 becz it's not a rotated sorted array it's just a normal ascending sorted array.
so (-1 + 1) -> 0 first element
 */

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }

        public static int findMin(int[] nums) {
            int pivot = findPivot(nums);
            return nums[pivot + 1];                // smallest element in rotated sorted array is the element just after the pivot.
        }

        public static int findPivot(int[] nums) {
            int start = 0 , end = nums.length - 1;

            while(start < end) {
                int mid = start + (end - start)/2;
                if(mid < end && nums[mid] > nums[mid + 1]) {
                    return mid;
                }
                if(mid > start && nums[mid] < nums[mid - 1]) {
                    return mid - 1;
                }
                if(nums[start] <= nums[mid]) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
            return -1;
        }
    }

