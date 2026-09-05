/*
Isomorphic String -> Strings are called Isomorphic when every single character in String s has a single pair with a character in String t and vice versa( i.e, every single character in 
String t must have a single pair with a character in String s.
So for it we need 2 hashmaps one for s -> t relationship and other for t -> s relationship.
Why 2 becz for eg :  s = "ab" , t = "cc"  if we only check the relationship of s -> t it is looking good as a -> c and b -> c but strings are isomorphic when a single character has a pair 
with other single character but here 'c' is having pair with a and b both so its "false"

Example 1:
Input: s = "egg", t = "add"
Output: true

Example 2:
Input: s = "f11", t = "b23"
Output: false

Example 3:
Input: s = "paper", t = "title"
Output: true
*/

public class IsomorhicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if(sToT.containsKey(a) && sToT.get(a) != b) return false;
            if(tToS.containsKey(b) && tToS.get(b) != a) return false;

            sToT.put(a,b);
            tToS.put(b,a);
        }
        return true;
    }
}
