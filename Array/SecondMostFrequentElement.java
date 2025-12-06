package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
phle to map mae store kra elements ko as keys and unke frequency as values then Map.Entry unke unke list banaye
and sort kra according to their values(descending) then just return the key's element value(frequency) at index
1(becz its second most freq)
agr first hota to 0th index waala and so on.....
 */

public class SecondMostFrequentElement {
        public static int secondMostFrequent(int[] arr) {
            // Step 1: Count frequency of each element
            Map<Integer, Integer> freq = new HashMap<>();
            for (int num : arr) {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }

            // Step 2: Sort entries by frequency (descending)
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(freq.entrySet());
            list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            // Step 3: Return the key of second element
            if (list.size() < 2) {
                return -1; // Not enough unique elements
            }
            return list.get(2).getKey();
        }

        public static void main(String[] args) {
            int[] arr = {1, 1, 2, 2, 2, 3};
            System.out.println(secondMostFrequent(arr)); // Output: 1
        }
}
