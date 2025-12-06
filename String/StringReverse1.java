package String;

/*
Isme we are reverse only every word in string not there positions.
Mr Ding!  ->  rM !gniD
 */

public class StringReverse1 {
    static String reverse(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String reversed = new StringBuilder(words[i]).reverse().toString();
            result.append(reversed);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }
}