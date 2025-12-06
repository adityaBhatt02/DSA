package Greedy.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
approach is simple sort every interval by ascending order of their first element(0) then create a list of int[] then add a current array into that the current array is
the first interval from the intervals array.
Then loop through every interval and check if the first element of the current interval is smaller or equal to the current array(which is in list) if yes -> then compare
the max of the second element of the current interval and the current array(in list) basically this is where merging is done.
if no the first element of the current interval is greater than the current array's second element then the current array is the current interval and then add it to the
list.
then at last change the list to array.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
    }

    public static int[][] merge(int[][] intervals) {
            // Step 1: sort by start
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

            List<int[]> result = new ArrayList<>();
            int[] current = intervals[0];
            result.add(current);

            for (int[] interval : intervals) {
                if (interval[0] <= current[1]) {
                    // overlap -> merge
                    current[1] = Math.max(current[1], interval[1]);
                } else {
                    // no overlap -> add new interval
                    current = interval;
                    result.add(current);
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }




