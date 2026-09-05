package String;

/*
Why specifically != 0?
Because we don't merely want prefix to exist somewhere in the string.
We want prefix to be at the BEGINNING.

For example:
"xxflower".indexOf("flower")
returns -> 2

Because:
x x f l o w e r
0 1 2 3 4 5 6 7
    ↑
So:
indexOf("flower") == 2
It found it, but not at the beginning.

For Longest Common Prefix, we need:
indexOf(prefix) == 0
Meaning:
"prefix starts at index 0."


Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

public class LongestCommonPrefix {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0) {
                return "";
            }

            String prefix = strs[0];

            for(int i = 1 ; i < strs.length ; i++) {
                while(strs[i].indexOf(prefix) != 0) {          // if the substring prefix is in strs at the start it will give 0 otherwise if the substring(prefix) is not present in the substring yet it will give -1.
                    prefix = prefix.substring(0 , prefix.length() - 1);

                    if(prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }
}
