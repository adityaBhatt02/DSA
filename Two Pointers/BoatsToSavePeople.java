/*
You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat
can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of
those people is at most limit.
Return the minimum number of boats to carry every given person.

Example 1:
Input: people = [1,2], limit = 3
Output: 1
Explanation: 1 boat (1, 2)

Example 2:
Input: people = [3,2,2,1], limit = 3
Output: 3
Explanation: 3 boats (1, 2), (2) and (3)

Example 3:
Input: people = [3,5,3,4], limit = 5
Output: 4
Explanation: 4 boats (3), (3), (4), (5)
 */

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0, right = people.length - 1, boats = 0;

        while (left <= right) {
            if(people[left] + people[right] <= limit) left++;               // if the heaviest and the lightest is in the range of limit then we carry both of them

            right--;                                // heaviest person will always gets a boat
            boats++;
        }
        return boats;
    }
}

/*
After sorting:

[lightest ........ heaviest]
   ↑                    ↑
 left                 right
We always handle the heaviest person first.

Then:
If lightest + heaviest fits
people[left] + people[right] <= limit

They can share a boat, so:
left++;
right--;
boats++;


If they don't fit
people[left] + people[right] > limit

Then the heaviest person cannot share with anyone, because the left pointer is already the lightest person.

So:
right--;
boats++;

The important part is:
Heaviest person is guaranteed to use one boat. The only question is whether we can put the lightest person in that same boat.
 */