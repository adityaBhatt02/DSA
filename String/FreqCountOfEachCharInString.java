package Array;

import java.util.HashMap;
import java.util.Map;

public class FreqCountOfEachCharInString {
     public static void countFreq(String s) {
            Map<Character , Integer> map = new HashMap<>();
            for(int i = 0 ; i < s.length() ; i++) {
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }

            for(Map.Entry<Character , Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        public static void main(String[] args) {
            String s = "abacabcd";
            countFreq(s);
        }
    }