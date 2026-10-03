/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:
Input: s = "leetcode"
Output: 0
Explanation:
The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:
Input: s = "loveleetcode"
Output: 2

Example 3:
Input: s = "aabb"
Output: -1


s only contains lower letter characters
 */


// O(n) time complexity and O(1) space complexity
public class FirstUniqueCharacterInAStringApproach {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;

        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (freq[c] == 1) return i;
        }

        return -1;
    }
}

// O(n) time complexity and O(n) space complexity
class FirstUniqueCharacterInAStringApproachII{
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        int i = 0;
        for(char c : s.toCharArray()) {
            if(map.get(c) == 1) return i;
            i++;
        }

        return -1;
    }
}