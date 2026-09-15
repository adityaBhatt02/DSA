package Recursion;

public class SkipACharacter {
    static String skip(String s , char c) {
        if (s.isEmpty()) {
            return "";
        }

        char ch = s.charAt(0);

        if(ch == c) {
            return skip(s.substring(1) , c);
        }else {
            return ch + skip(s.substring(1) , c);
        }
    }

    public static void main(String[] args) {
        System.out.println(skip("abacdra" , 'a'));
    }
}
