/*
Approach - 1 (HashMap + sorting) 

Steps :
String
  ↓
1. Count frequencies
  ↓
2. Put HashMap entries into List
  ↓
3. Sort the List
  ↓
4. Build answer

Time complexity of Approach 1 ->

Step 1 — Count frequencies. We visit every character once.
If string length is n: O(n)

Step 2 — Put HashMap entries into a List
How many entries are in the HashMap?  Only the distinct characters. That's k.
So: O(k)

Step 3 — Sort the List 
This list contains k elements:
(e, 2)
(t, 1)
(r, 1)
...
We're sorting k elements.
Java's object sorting uses a comparison sort, so: O(k log k)
This is the expensive part.

Step 4 — Build the answer
Suppose:
e → 5
a → 3
t → 1

We append:
eeeee
aaa
t
How many characters do we append in total?   Exactly n, because the answer contains all characters from the original string.
Therefore: O(n)

Put everything together
O(n) + O(k) + O(k log k) + O(n)
Drop constants and lower-order terms: O(n + k log k)
Since k ≤ n, the worst case can be: O(n log n)

So Approach 1:
Time = O(n + k log k)
Worst case = O(n log n)


Space complexity of Approach 1 ->

We have: 
HashMap => Stores k distinct characters: O(k)

List => Also contains k entries: O(k)

StringBuilder => The final answer has n characters: O(n)

So:
O(k) + O(k) + O(n) → O(n + k)

Since k ≤ n: O(n)

Approach 1:
Time:  O(n + k log k)
Space: O(n)
*/

public class SortCharactersByFrequency1 {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : list) {
            int val = entry.getValue();
            while(val != 0) {
                result.append(entry.getKey());
                val--;
            }
        }

        return result.toString();    
    }
}
