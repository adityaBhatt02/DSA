package Greedy.Intervals;

/*
so in this ques we are given intervals, and they are already sorted, and we are also given a new interval, and we are asked to insert that interval into other intervals
without making any overlapping b/w them.
so our approach is that : BEFORE → OVERLAP → AFTER

        BEFORE          OVERLAP              AFTER

     [1,3] [2,4]      [6,8] [7,10]          [15,18]
                        ↑
                    new = [5,7]

Actually:
[1,3]     → BEFORE
[2,4]     → BEFORE
[6,8]     → OVERLAP
[7,10]    → OVERLAP
[15,18]   → AFTER


The 3 conditions to memorize -->
Before: intervals[i][1] < newInterval[0]                  "Does this interval finish before the new interval even starts?"
End < start → copy it.

Overlap: intervals[i][0] <= newInterval[1]                "Does this interval start before the current merged newInterval has finished?"
Start <= end → merge it.

After: intervals[i][0] > newInterval[1]                   "add everything remaining"
Start > end → done merging → copy rest.
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
