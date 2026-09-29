public class FindMedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Binary search on the smaller array
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;

        int start = 0, end = m;

        // Number of elements that should be on the left side
        int leftSize = (m + n + 1) / 2;

        while (start <= end) {

            // i = partition position in nums1
            int i = start + (end - start) / 2;

            // j = partition position in nums2
            int j = leftSize - i;

            // Boundary elements around the partitions
            int leftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];

            int rightA = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int leftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];

            int rightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

            // Correct partition
            if (leftA <= rightB && leftB <= rightA) {

                // Odd total length
                if ((m + n) % 2 == 1) {
                    return Math.max(leftA, leftB);
                }

                // Even total length
                int leftMax = Math.max(leftA, leftB);
                int rightMin = Math.min(rightA, rightB);

                return (leftMax + rightMin) / 2.0;
            }

            // Partition in nums1 is too far right
            if (leftA > rightB) {
                end = i - 1;
            }

            // Partition in nums1 is too far left
            else {
                start = i + 1;
            }
        }

        return -1.0;
    }
}

/*
This is just the simple approach to first merge both the sorted arrays and create a new sorted array and then find the mid
if the length of the new sorted array is odd just return the mid and if length is even then there are 2 mids (mid and mid + 1)
so there median is there sum / 2.

Time complexity

m = nums1.length
n = nums2.length

merge() processes every element exactly once:
nums1: m elements
nums2: n elements
So -> O(m + n)

Then finding mid and calculating the median is -> O(1)

Therefore overall -> Time: O(m + n)


Space complexity :

int[] result = new int[nums1.length + nums2.length];

So, we store all m + n elements: Space: O(m + n)

variables: i, j, k, start, end, mid
are only constant extra space: O(1)
but the result array dominates.

Therefore:
Space: O(m + n)
 */
class ApproachII {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = merge(nums1, nums2);

        int start = 0;
        int end = result.length - 1;

        int mid = start + (end - start) / 2;

        if (result.length % 2 == 0) {
            return ((double) result[mid + 1] + result[mid]) / 2;
        }

        return result[mid];
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        int[] result = new int[nums1.length + nums2.length];
        int k = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                result[k] = nums1[i];
                i++;
            } else {
                result[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            result[k] = nums1[i];
            i++;
            k++;
        }

        while (j < nums2.length) {
            result[k] = nums2[j];
            j++;
            k++;
        }

        return result;
    }
}