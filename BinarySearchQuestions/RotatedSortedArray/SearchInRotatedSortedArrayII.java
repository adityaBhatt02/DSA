/*
Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
 */


public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[mid] == target) return true;

            if(nums[start] == nums[mid] && nums[mid] == nums[end]) {        // removing duplicate from the search space
                start++;
                end--;
            } else if(nums[start] > nums[mid]) {                           // we are in right sorted half
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {                                                      // we are in left sorted half -> nums[start] <= nums[mid]
                if(nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return false;
    }
}


/*
Rotated Sorted Array I -->

Your approach was:
1. Find pivot
2. Now I know:
      [0 ... pivot]     is sorted
      [pivot+1 ... n-1] is sorted
3. Binary search the appropriate half
So you explicitly discovered the rotation point first.


Rotated Sorted Array II -->
Instead, at every iteration we ask:

            mid
             ↓
[ start ............... end ]
Which side is sorted right now?

If:
nums[start] <= nums[mid]
then: LEFT SIDE IS SORTED
[start ........ mid]

Otherwise: nums[start] > nums[mid]
then: RIGHT SIDE IS SORTED
[mid ........ end]

Then we ask:
Can the target exist inside that sorted side?

If yes → keep that side.
If no → throw that side away.

So we're essentially doing:

identify sorted half
        ↓
does target belong there?
      ↙   ↘
    yes    no
     ↓      ↓
  keep it  discard it
That's the beautiful part of the problem.



And the observation about "reducing the search by a lot"
Exactly!

Normally:

n → n/2 → n/4 → n/8 → ...
That's: O(log n)

But duplicates create this nasty situation: nums[start] == nums[mid] == nums[end]
Now you can't determine which side is sorted.

So you can't safely say: "throw away half"

Instead you only know: start and end are duplicates of mid

So you do:
start++;
end--;

You may only reduce: n → n - 2

instead of: n → n / 2

And in the worst case:
n → n-2 → n-4 → n-6 → ...

which gives: O(n)
 */