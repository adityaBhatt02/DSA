/*
The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur more than
once in a DNA molecule. You may return the answer in any order.

Example 1:
Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
Output: ["AAAAACCCCC","CCCCCAAAAA"]

Example 2:
Input: s = "AAAAAAAAAAAAA"
Output: ["AAAAAAAAAA"]
 */

// most optimal appraoch
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> result = new HashSet<>();                    // for not storing duplicate substring if already added one (like > 1 nope, == 2)

        for (int i = 0; i <= s.length() - 10; i++) {
            String current = s.substring(i, i + 10);

            if (!seen.add(current)) result.add(current);         // if already seen this substring add it to result set

        }
        return new ArrayList<>(result);
    }
}

// good approach but taking extra space becz of a map , list , and stringbuilder
class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int left = 0, right = 0;
        while(right < s.length()) {
            sb.append(s.charAt(right));

            if(sb.length() == 10) {
                String current = sb.toString();

                map.put(current, map.getOrDefault(current, 0) + 1);

                if(map.get(current) == 2) result.add(current);                // not > 1 becz that stored duplicates too

                sb.deleteCharAt(0);
                left++;
            }
            right++;
        }
        return result;
    }
}