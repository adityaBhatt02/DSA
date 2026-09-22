package Greedy;

import java.util.ArrayList;
import java.util.List;

/*
isme we need to return the maximum number of meetings that can take place in a room.(we also had return the whole order list also which means in which order the meetings
will go.
time slot should be valid like -> if a meeting is from 1-2 then only those meeting are allowed now whose starting hour is more than the end hour of previous meeting.

{isme greedy hae like sabse km time slots ke jo meetings hae(jinka end time km hae jldi khtm hojaenge) uske according sort kra so zyada se zyada meetings ho paaye km time
mae rather than ek meeting jo bhot time le}.
 */

class Meeting {                           // a meeting have starting and ending hour , and the position
    int start;
    int end;
    int pos;

    public Meeting(int s, int e , int p) {
        start = s;
        end = e;
        pos = p;
    }
}

public class nMeetingsInOneRoom {
    public static void main(String[] args) {
        int[] start = {1,3,0,5,8,5};
        int[] end = {2,4,6,7,9,9};

        List<Integer> order = maxMeetings(start , end);
        System.out.println(order);                                           // proper order of all meetings.
        System.out.println(order.size());                                   // if asked how many max meetings can be held.
    }

    static List<Integer> maxMeetings(int[] start , int[] end) {
        List<Meeting> meetings = new ArrayList<>();                      // stores meeting objects.

        for (int i = 0 ; i < start.length ; i++) {
            meetings.add(new Meeting(start[i] , end[i] , i + 1));                // traversing each starting and ending slot one by one and adding in meetings list.
        }

        meetings.sort((a , b) -> {                                  // sorting the lists according to end hour(Ascending) and if end hours are same for 2 meetings then according to pos.
            if(a.end == b.end) {
                return a.pos - b.pos;
            }
            return a.end - b.end;
        });

        List<Integer> order = new ArrayList<>();                         // stores the positon of the meetings.
        int freeSlot = -1;                                               // freeslot is basically after each meeting after that time room is free then another meeting can take place.

        for(Meeting meeting : meetings) {
            if (freeSlot < meeting.start) {
                order.add(meeting.pos);
                freeSlot = meeting.end;
            }
        }
        return order;
    }



}
