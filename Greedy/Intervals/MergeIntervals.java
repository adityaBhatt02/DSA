package Greedy.Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
First sort by start time.

Then:
current = first interval
result = [current]


Now for every next interval:

1. Overlap?
interval[0] <= current[1]
Yes → merge:
current[1] = max(current[1], interval[1])

Because the current merged interval expands.


2. No overlap?
interval[0] > current[1]

Then:
current = interval
result.add(current)

You've finished the previous group and started a new one.

One-line mental model
"Does the next interval start before my current merged interval ends?"

Yes → expand current.
No → start a new interval.

So:
[1,3] [2,6] [5,8] [10,12]

        overlap → merge
               ↓
         [1,8] [10,12]
And remember the reference detail you just understood:

current[1] = ...
modifies the same array already inside result.

While: current = interval;
makes current point to the new interval, then: 
result.add(current);
adds that new reference.
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




