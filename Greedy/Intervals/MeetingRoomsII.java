/*
Given an array of meeting time interval objects consisting of start and end times [[start_1,end_1],[start_2,end_2],...] (start_i < end_i), find the minimum number of rooms required to schedule 
all meetings without any conflicts.
Note: (0,8),(8,10) is NOT considered a conflict at 8.

Example 1:
Input: intervals = [(0,40),(5,10),(15,20)]
Output: 2

Explanation:
room1: (0,40)
room2: (5,10),(15,20)


Example 2:
Input: intervals = [(4,9)]
Output: 1


Example 3:
Input: intervals = [(1,5),(2,6),(3,7),(4,8),(5,9)]
Output: 4     

Explanation:
room1: (1,5),(5,9)                           -> a meeting end at 5 and another meeting starts at 5
room2: (2,6)
room3: (3,7)
room4: (4,8)
*/


/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() == 0) return 0;

        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> earliestEnd = new PriorityQueue<>();       // using Min heap for storing the end time of the intervals so smallest end time will be at the peek
        earliestEnd.add(intervals.get(0).end);

        for(int i = 1; i < intervals.size(); i++) {
            if(intervals.get(i).start < earliestEnd.peek()) {             // overlapping ( so it needs a new room )
                earliestEnd.add(intervals.get(i).end);
            } else {                                                      // non-overlapping 
                earliestEnd.poll();
                earliestEnd.add(intervals.get(i).end);
            }
        }
        return earliestEnd.size();                                       // size of the priority queue is basically how many rooms currently occupied 
    }
}
