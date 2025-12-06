package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Every element appears twice except for one in the array. Find that single one.
A light switch — each bit flips ON/OFF every time it appears.
Duplicates flip twice (ON then OFF), only the single one stays ON.
 */
public class SingleNumber {
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num;                   // we are using the XOR technique in which its like when XOR with 0 the num -> num , but when num XOR num -> 0(means cancel out)
                // so, result at start is 0(000) and num for eg is 4(100) then 0 ^ 4 is -> 100 and then if 4 comes again its 4 ^ 4 which is -> 0 (means duplicates get cancel out).
            }
            return result;
        }
}


// Every element appears thrice except for one in the array. Find that single one.
class SingleNumber2 {
    public int singleNumber(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for(int key: map.keySet()) {
            if(map.get(key) == 1) {
                return key;
            }
        }
        return -1;
    }
}


//  exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.
class SingleNumber3 {
        public int[] singleNumber(int[] nums) {
            Map<Integer , Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();

            for(int num : nums) {
                map.put(num , map.getOrDefault(num , 0) + 1);
            }

            for(int key : map.keySet()) {
                if(map.get(key) == 1) list.add(key);
            }

            return new int[] {list.get(0) , list.get(1)};
        }}