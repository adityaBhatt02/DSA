package SlidingWindowAndTwoPointers.Hashmaps;

import java.util.HashSet;

public class Hashing {
    public static void main(String[] args) {
//        String a = "Aditya";
//        int b = a.hashCode();
//        System.out.println(b);

//        HashMap<String , Integer> map = new HashMap<>();
//        map.put("Aditya" , 1);
//        map.put("Ishika" , 2);
//        map.put("Nitin" , 3);
//        System.out.println(map.get("Aditya"));
//        System.out.println(map.getOrDefault("Pratham" , 4));
//        System.out.println(map.containsKey("Ishika"));


        HashSet<Integer> set = new HashSet<>();
        set.add(99);
        set.add(69);
        set.add(12);
        set.add(99);                   // duplicates are not stored in set.
        set.add(89);
        System.out.println(set);
    }
}
