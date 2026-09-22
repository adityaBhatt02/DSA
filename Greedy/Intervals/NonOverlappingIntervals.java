package Greedy.Intervals;

import java.util.Arrays;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.

Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;

        Arrays.sort(intervals , (a , b) -> Integer.compare(a[1] , b[1]));

        int count = 1;                                                          // counting non-overlapping intervals only
        int currentEnd = intervals[0][1];

        for(int i = 1 ; i < intervals.length ; i++) {
            if(intervals[i][0] >= currentEnd) {
                count++;
                currentEnd = intervals[i][1];
            } else {
                currentEnd = Math.min(currentEnd, intervals[i][1]);            // keep that interval whose end is smaller so that we have room for more intervals(removing will be next then)
            }
        }
        return intervals.length - count;                                       // intervals.length - count gives overlapping intervals count 
    }
}

/*
That's the greedy intuition:
When two intervals overlap, we want to keep the interval that ends earlier, because it leaves the maximum amount of room for future intervals.

It isn't directly "we remove fewer right now." We are making the choice that gives us the best chance to keep more intervals later, which ultimately means fewer removals overall.

Example:
[1, 100]
[2, 3]
[4, 5]

[1,100] overlaps [2,3].

If we keep [1,100]:
currentEnd = 100

Then [4,5] also overlaps, so we'd have to remove it too.

We keep only: [1,100]

But if we keep [2,3]:
currentEnd = 3

Now [4,5] fits:
4 >= 3 

So we keep:
[2,3]
[4,5]

That's 2 intervals kept instead of 1.

So the greedy rule is:

Overlap
   ↓
Keep the one with smaller end
   ↓
Smaller currentEnd
   ↓
More room for future intervals
   ↓
Potentially keep more intervals
   ↓
Fewer removals overall
 */

