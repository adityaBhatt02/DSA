//package BinarySearchQuestions.MountainArray;//package BinarySearchQuestions;
/////**
//// * // This is MountainArray's API interface.
//// * // You should not implement it, or speculate about its implementation
//// * interface MountainArray {
//// *     public int get(int index) {}
//// *     public int length() {}
//// * }
//// */
//
//
//public class FindInMountainArray {
//
//    class Solution {
//        public int findInMountainArray(int target, MountainArray mountainArr) {
//            int peak = peakOfMountain(mountainArr);
//
//            int small = binarySearch(target, mountainArr, 0, peak, true);
//            if (small != -1) return small;
//
//            return binarySearch(target, mountainArr, peak + 1, mountainArr.length() - 1, false);
//        }
//
//        public int peakOfMountain(MountainArray mountainArr) {
//            int start = 0, end = mountainArr.length() - 1;
//
//            while (start < end) {
//                int mid = start + (end - start) / 2;
//                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
//                    start = mid + 1;
//                } else {
//                    end = mid;
//                }
//            }
//            return start;
//        }
//
//        public int binarySearch(int target, MountainArray mountainArr, int start, int end, boolean ascending) {
//            while (start <= end) {
//                int mid = start + (end - start) / 2;
//                int midVal = mountainArr.get(mid);
//
//                if (midVal == target) return mid;
//
//                if (ascending) {
//                    if (midVal < target) {
//                        start = mid + 1;
//                    } else {
//                        end = mid - 1;
//                    }
//                } else {
//                    if (midVal < target) {
//                        end = mid - 1;
//                    } else {
//                        start = mid + 1;
//                    }
//                }
//            }
//            return -1;
//        }
//    }
//
//}
