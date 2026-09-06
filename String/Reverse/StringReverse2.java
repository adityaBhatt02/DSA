package String;

import java.util.Scanner;

/*
String s = "I Love CoderByte"
o/p -> "etyBredoC evoL I"
 */

public class StringReverse2 {
    public static String reverse(String str) {
        String[] sArr = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String s : sArr) {
            String word = new StringBuilder(s).reverse().toString();
            result.insert(0, word + " ");
        }

        return result.toString();
    }
}
