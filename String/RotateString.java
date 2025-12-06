package String;

/*
Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s
Input: s = "abcde", goal = "cdeab"
Output: true

Input: s = "abcde", goal = "abced"
Output: false


s = "abc"
when u do s + s -> "abcabc"
now every possible compbination is inside s+s -> abc , bac , cab
now if goal string is valid then our func will return true
 */
public class RotateString {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) return false;

        String doubled = s + s;    // every possible rotated string will be there
        return doubled.contains(goal);
    }
}
