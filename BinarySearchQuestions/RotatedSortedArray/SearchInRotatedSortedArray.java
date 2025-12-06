package BinarySearchQuestions.RotatedSortedArray;

/* In every rotatedSortedArray there is a pivot (that element after that all elements are in ascending order and before that also including it)

steps -
1) find the pivot
2) search in first half(by binary search)                           from - (start to pivot)                        {if the element found there , return the index}
3) then search in second half(by binary search)                     from - (pivot+1 to end)                        {if the element found there , return the index}


Note : All elements after pivot will be smaller than the start(i.e, 0th index waale se)
 */


public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 1;
        int ans = search(arr , target);
        System.out.println(ans);
    }


    static int search(int[] nums , int target) {
        int pivot = findPivot(nums);

        if(pivot == -1) {
            // if you don't find pivot means the array is not rotated then just do normal binary search.
            return binarySearch(nums , target , 0 , nums.length - 1);
        }

        // if pivot is found , you have found 2 ascending sorted array.
        if(nums[pivot] == target) {
            return pivot;
        }

        // left asc
        if(nums[0] <= target) {
            return binarySearch(nums, target, 0, pivot - 1);
        }

        // right asc
        return binarySearch(nums , target , pivot + 1 , nums.length - 1);
    }


    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (end > mid && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (start < mid && arr[mid - 1] > arr[mid]) {
                return mid - 1;
            }
            if (arr[start] > arr[mid]) {
                end = mid - 1;
            }else {                               // arr[start] <= arr[mid]
                start = mid + 1;
            }
        }
    return -1;
    }


    static int binarySearch(int[] arr , int target , int start , int end) {
        while (start <= end) {
            int mid = start + (end - start)/2;

                if(arr[mid] > target) {
                    end = mid - 1;
                } else if(arr[mid] < target) {
                    start = mid + 1;
                }else {
                    return mid;
                }
            }
        return -1;
    }
}

