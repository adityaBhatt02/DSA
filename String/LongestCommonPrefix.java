package Array;

// ["flower" , "flow" , "flight"] -> prefix = "fl"
public class LongestCommonPrefix {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0) {
                return "";
            }

            String prefix = strs[0];

            for(int i = 1 ; i < strs.length ; i++) {
                while(strs[i].indexOf(prefix) != 0) {          // if the substring prefix is in strs at the start it will give 0 otherwise if the substring(prefix) is not present in the substring yet it will give -1.
                    prefix = prefix.substring(0 , prefix.length() - 1);

                    if(prefix.isEmpty()) return "";
                }
            }
            return prefix;
        }
}
