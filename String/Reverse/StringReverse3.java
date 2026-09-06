package String;

/*
isme we dont have to reverse every word we just have to reverse the positions.
Input: s = "the sky is blue"
Output: "blue is sky the"

Input: s = "  hello world  "
Output: "world hello"
Explanation: Your reversed string should not contain leading or trailing spaces.

Input: s = "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class StringReverse3 {
        public String reverse(String s) {
            s = s.trim().replaceAll("\\s+", " ");             // .trim() is used to remove initial and last spaces and we used \\s+ so that whenever extra spaces(more than 1 are there) replace it with a single space b/w words.
            String[] words = s.split(" ");

            int start = 0;
            int end = words.length - 1;

            while(start < end) {
                String temp = words[start];
                words[start] = words[end];
                words[end] = temp;

                start++;
                end--;
            }

            return String.join(" " , words);                         // .join is used to convert a String[] to String.
        }
    }