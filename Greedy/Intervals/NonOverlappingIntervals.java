package Greedy.Intervals;

import java.util.Arrays;

/*
so this ques is like the inverse of nMeetingsInOneRoom in this ques we are given intervals, and we need to
find how many overlapping intervals are present(or how many intervals we need to remove)
so overlapping intervals are those intervals whose start is less than the end of their previous interval.

So, what we did is just sort all intervals(in ascending order of their ends) and then just count number of
non overlapping intervals present and then when a overlapping interval comes just don't run the counter for
it and then at last just return how many non overlapping intervals we need to remove.
{greedy in this is same like sort kr rhe hae to, always take those intervals first that ends earliest} becz
->An interval that ends earlier leaves more room for the remaining intervals.
->If we instead pick a long interval, it blocks others unnecessarily.
 */
public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals , (a , b) -> Integer.compare(a[1] , b[1]));

        int count = 1;
        int currentEnd = intervals[0][1];

        for(int i = 1 ; i < intervals.length ; i++) {
            if(intervals[i][0] >= currentEnd) {
                count++;
                currentEnd = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}

/*
Extra tip -
In arrays we can use Integer.compare inside Arrays.sort for only Integer[] , Double[] etc. but not for int[] , double[] etc. types.
becz Integer.compare only works for reference type not primitive type (int[] is not primitive but elements inside it like 1 , 2 ... are primitive)

So we can use Integer.compare with 2-D arrays also int[][] becz inside it the elements are array which are not primitive they are objects.
 */

