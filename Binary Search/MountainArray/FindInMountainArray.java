package BinarySearchQuestions.MountainArray;
///**
// * // This is MountainArray's API interface.
// * // You should not implement it, or speculate about its implementation
// * interface MountainArray {
// *     public int get(int index) {}
// *     public int length() {}
// * }
// */


class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peek = peek(mountainArr, 0, mountainArr.length() - 1);
        if(mountainArr.get(peek) == target) return peek;

        int ans1 = orderAgnoSearch(mountainArr, 0, peek - 1, target);
        int ans2 = orderAgnoSearch(mountainArr, peek + 1, mountainArr.length() - 1, target);

        if(ans1 != -1) return ans1;
        if(ans2 != -1) return ans2;
            
        return -1;
    }

    public int orderAgnoSearch(MountainArray mountainArr, int start , int end, int target) {

        if(mountainArr.get(start) < mountainArr.get(end)) {
            while(start <= end) {
                int mid = start + (end - start)/2;

                if(mountainArr.get(mid) > target) {
                    end = mid - 1;
                }else if(mountainArr.get(mid) < target) {
                    start = mid + 1;
                }else {
                    return mid;
                }
            }}
        else {
            while(start <= end) {
                int mid = start + (end - start)/2;

                if(mountainArr.get(mid) > target) {
                     start = mid + 1;
                }else if(mountainArr.get(mid) < target) {
                    end = mid - 1;
                }else {
                    return mid;
                }
            }
        }
        return -1;
    }

    public int peek(MountainArray mountainArr, int start, int end) {
        while(start < end) {
            int mid = start + (end - start)/2;

            if(mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            }else {
                start = mid + 1;
            }
        }
        return start;
    }
}
