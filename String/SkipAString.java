package String;

public class SkipAString {
    static String skip(String str, String strToRemove) {
        if (str.isEmpty()) {
            return "";
        }

        if (str.length() >= strToRemove.length() &&
                str.substring(0, strToRemove.length()).equalsIgnoreCase(strToRemove)) {
            return skip(str.substring(strToRemove.length()), strToRemove);
        } else {
            return str.charAt(0) + skip(str.substring(1), strToRemove);
        }
    }

    public static void main(String[] args) {
        System.out.println(skip("Aditya is a good boy. And aditya is a badass!" , "Aditya"));
    }
}
