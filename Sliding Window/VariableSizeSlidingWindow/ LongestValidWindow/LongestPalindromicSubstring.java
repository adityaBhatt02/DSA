/*
The core idea -> Every palindrome has a center. For every index, check both possible centers and expand outward.

There are only 2 types of centers:

ODD palindrome :
"racecar"

r a c e c a r
      ↑
   one center

→ (i, i)


EVEN palindrome
"abba"

a b b a
  ↑ ↑
two center characters

→ (i, i + 1)


Therefore:

for every i:
    check (i, i)       → odd
    check (i, i + 1)   → even


1. Expand around the center

Create a helper:

private int expand(String s, int left, int right) {
    while (left >= 0 &&
           right < s.length() &&
           s.charAt(left) == s.charAt(right)) {

        left--;
        right++;
    }

    return right - left - 1;
}


What is it doing?

Suppose:
"babad"

We start:
left = 1
right = 1
because we're checking the palindrome centered at a.

Then:

a == a ✓
Expand:

b a b a d
↑   ↑
L   R
b == b ✓
Expand again:

left = -1
right = 3
Stop.

The palindrome was:
"bab"


Why:
return right - left - 1;

Because after the loop:
left and right are one position OUTSIDE the palindrome.

So:
return right - left - 1;
for this expand helper.


2. Check every possible center
Now:

for (int i = 0; i < s.length(); i++) {
    int odd = expand(s, i, i);
    int even = expand(s, i, i + 1);
    int len = Math.max(odd, even);
    ...
}

Think:

              i
              ↓
         ┌────┴────┐
         ↓         ↓
       (i,i)     (i,i+1)
         ↓         ↓
        ODD       EVEN

For every character:

"Could a palindrome be centered ON me?"

and

"Could a palindrome be centered BETWEEN me and the next character?"

Then move to the next i.
This guarantees you don't miss either type.


3. Keep the longest one

Suppose:
odd = 3
even = 4

Then:
int len = Math.max(odd, even);

means:
len = 4

Now compare it with the palindrome we've already saved:
if (len > end - start + 1)

Remember:

start ... end
is our current best palindrome.

Its length is:
end - start + 1

So we're asking:
"Is this new palindrome longer than my previous best?"

If yes, update it.

4. The annoying formulas

start = i - (len - 1) / 2;
end = i + len / 2;
You can memorize these.

Their job is simply:

Center + length → start and end indices

Don't overthink them during the interview.

i   = center
len = palindrome length

        ↓

start = i - (len - 1) / 2
end   = i + len / 2

They work for both odd and even palindromes.

Example: "bab"
i = 1
len = 3
start = 1 - (3 - 1)/2
      = 0

end = 1 + 3/2
    = 2
So:

0 → 2
"bab"
Example: "abba"
i = 1
len = 4
start = 1 - (4 - 1)/2
      = 0

end = 1 + 4/2
    = 3
So:

0 → 3
"abba"


🧠 Your final mental model
Don't memorize the whole code.

Memorize this story:

Longest Palindromic Substring
            ↓
Every palindrome has a center
            ↓
There are 2 center types
       ↙              ↘
   (i, i)          (i, i+1)
    ODD              EVEN
       ↘              ↙
        expand outward
              ↓
        get palindrome length
              ↓
      keep the longest one
              ↓
    calculate start/end
              ↓
         return substring

And the 4 pieces worth memorizing are:

expand(s, i, i);        // odd
expand(s, i, i + 1);    // even

return right - left - 1;

start = i - (len - 1) / 2;
end = i + len / 2;

substring(start, end + 1);
That's it.

Don't try to memorize the formulas as random math. Associate each one with its job:

Code	Meaning
(i, i)	center ON character → odd
(i, i + 1)	center BETWEEN characters → even
right - left - 1	expansion stopped outside palindrome
start/end formulas	center + length → boundaries
end + 1	Java substring end is exclusive
 */

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        for(int i = 0; i < s.length(); i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);

            int len = Math.max(odd, even);

            if(len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }
}



// Worst brute force soln : O(n^2)
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);

                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }

        return longest;
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}