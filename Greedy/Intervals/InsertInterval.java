package Greedy.Intervals;

/*
so in this ques we are given intervals, and they are already sorted, and we are also given a new interval, and we are asked to insert that interval into other intervals
without making any overlapping b/w them.
so our approach is that :
1)before any overlapping begins insert the left intervals to the list of arrays(condition for checking this is that the interval on left should have
end smaller than the start of the newInterval
2)then from where the overlapping start(condition for that is newInterval's end should be greater or equal to the start of the intervals in intervals array ..... and then
just take the "min" as newInterval's start and "max" as newInterval's end {to make the range for the new interval} and then add it to the result list.
3)then just add the remaining intervals from the right.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(Arrays.deepToString(insert(intervals, newInterval)));                    // o/p -> [[1,2],[3,10],[12,16]]
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int i = 0;

        // Case 1: Add all intervals ending before newInterval starts
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Case 2: Merge overlapping intervals with newInterval
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Case 3: Add all remaining interval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}