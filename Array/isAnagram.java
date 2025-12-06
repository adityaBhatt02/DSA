package Array;

import java.util.Arrays;

public class isAnagram {
    public static void main(String[] args) {
        String str1 = "ate";
        String str2 = "eat";
        System.out.println(isAna(str1 , str2));
    }
    public static boolean isAna(String s, String t) {
        s = s.replaceAll("//s" , "").toLowerCase();
        t = t.replaceAll("//s" , "").toLowerCase();

        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        if(cs.length != ct.length) {
            return false;
        }

        Arrays.sort(cs);
        Arrays.sort(ct);

        return Arrays.equals(cs , ct);
    }
}
