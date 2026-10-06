package Array;

import java.util.HashSet;

// [100,4,200,1,3,2]
// [1,0,1,2]

public class LongestConsecutiveSequence {
        public int longestConsecutive(int[] nums) {
            if (nums.length == 0) return 0;

            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) set.add(num); // remove duplicates automatically

            int longest = 0;

            for (int num : set) {
                if (!set.contains(num - 1)) {                            // we want to only start from the start of the sequence.
                    int current = num;
                    int count = 1;

                    while (set.contains(current + 1)) {
                        current++;
                        count++;
                    }
                    longest = Math.max(longest, count);
                }
            }
            return longest;
        }
}
