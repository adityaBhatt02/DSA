/*
Given an array nums of n integers, where nums[i] represents the number of pages in the i-th book, and an integer m
representing the number of students, allocate all the books to the students so that each student gets at least one book,
each book is allocated to only one student, and the allocation is contiguous.
Allocate the books to m students in such a way that the maximum number of pages assigned to a student is minimized.
If the allocation of books is not possible, return -1.

Example 1:
Input: nums = [12, 34, 67, 90], m=2
Output: 113
Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get
the last one.

Example 2:
Input: nums = [25, 46, 28, 49, 24], m=4
Output: 71
Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.
 */

public class BookAllocationProblem {
    public int findPages(int[] nums, int m) {
        if(m > nums.length) return -1;              // number of students are greater than number of available books

        int minPage = Integer.MIN_VALUE;
        int maxPage = 0;

        for(int num : nums) {
            minPage = Math.max(minPage, num);
            maxPage += num;
        }

        while(minPage < maxPage) {
            int mid = minPage + (maxPage - minPage)/2;

            if(canAllocate(nums, m, mid)) {
                maxPage = mid;
            } else {
                minPage = mid + 1;
            }
        }
        return minPage;
    }

    private boolean canAllocate(int[] nums, int m, int maxAllowedSum) {
        int currentSum = 0, subarrays = 1;

        for(int num : nums) {
            if(currentSum + num <= maxAllowedSum) {
                currentSum += num;
            } else {
                subarrays++;
                currentSum = num;
            }
        }
        return subarrays <= m;
    }
}

/*
 90 91 92 93 ........105....112..113..115...118.....146.........200 201 202 203
                                 s e
 */


