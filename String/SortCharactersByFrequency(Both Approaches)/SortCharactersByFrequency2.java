/*
Approach - 2 (HashMap + Bucket Sort)

Time complexity of Bucket Sort :

We don't sort the k characters.
We make buckets based on frequency.

For:  s = "tree"
we have:
e → 2
t → 1
r → 1

Buckets:
bucket[1] → [t, r]
bucket[2] → [e]

Remember: n = length of string
Maximum possible frequency is n.

So we have:
bucket[0]
bucket[1]
bucket[2]
...
bucket[n]

Step 1 — Count frequencies
Same as before: O(n)

Step 2 — Put characters into buckets
We have k distinct characters.

For each one: bucket[count].add(ch);
So: O(k)

Step 3 — Walk through buckets

We go: n → n-1 → n-2 → ... → 1
How many buckets are there? => n.
So:O(n)

BUT we're not sorting anything.
We're simply visiting bucket positions.
That's the entire advantage.

Step 4 — Build answer
Again, we're eventually appending all n characters: O(n)

Total
O(n) + O(k) + O(n) + O(n) → O(n + k)

And because: k ≤ n
we can simplify say: O(n)



Space complexity of Bucket Sort :

HashMap => O(k)

Buckets we create n + 1 bucket positions => O(n)

StringBuilder => O(n)

So: O(k + n + n) → O(n + k)
Since k ≤ n  -->  O(n)

Bucket approach:
Time:  O(n)
Space: O(n)
 */

public class SortCharactersByFrequency2 {
   public String frequencySort(String s) {
       Map<Character, Integer> freq = new HashMap<>();

       for(char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

       List<Character>[] bucket = new List[s.length() + 1];
       for(char key : freq.keySet()) {
           int val = freq.get(key);

           if(bucket[val] == null) bucket[val] = new ArrayList<>();

           bucket[val].add(key);
       }

       StringBuilder result = new StringBuilder();
       for(int i = bucket.length - 1; i >= 0; i--) {
           if(bucket[i] == null) continue;

           for(char c : bucket[i]) {
               for(int j = 0; j < i; j++) result.append(c);
           }
       }
       return result.toString();
   }
}
