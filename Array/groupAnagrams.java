package Array;

import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> result = groupAna(input);

        for (List<String> group : result) {
            System.out.println(group);
        }

        List<String> list = groupAna1(input , "ant");
        System.out.println(list);
    }

    public static List<List<String>> groupAna(String[] strs) {
        // Map with key as sorted string and value as list of anagrams
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            // Sort characters of the word to use as a key
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);

            // Add word to the corresponding list
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(word);
        }

        // Return all groups
        return new ArrayList<>(map.values());
    }

    public static List<String> groupAna1(String[] strs , String word) {
        Map<String , List<String>> map = new HashMap<>();

        for(String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String sorted = new String(ch);

            if(!map.containsKey(sorted)) {
                map.put(sorted , new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        char[] ch = word.toCharArray();
        Arrays.sort(ch);
        String sorted = new String(ch);
        if(map.containsKey(sorted)) {
            return map.get(sorted);
        }

        return new ArrayList<>();
    }
}
