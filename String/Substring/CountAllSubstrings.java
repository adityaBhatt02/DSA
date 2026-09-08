/*
Printing all substrings in a string - substring is the continous part of a string.
Total subsstrings in a string -> n(n + 1)/2
 */

 class CountAllSubstrings {
    public static void main(String[] args) {
        String s = "abcd";
        substring(s);
    }

    private static void substring(String s) {
        for(int i = 0; i < s.length(); i++) {
            StringBuilder current = new StringBuilder();
            for(int j = i; j < s.length(); j++) {
                current.append(s.charAt(j));
                System.out.println(current);
            }
        }
    }
}