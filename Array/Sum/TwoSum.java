package Array.Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        int target = 19;

        System.out.println(Arrays.toString(twoSum(arr , target)));
    }

    static int[] twoSum(int[] arr , int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int i = 0 ; i < arr.length ; i++) {
            int compliment = target - arr[i];
            if(map.containsKey(compliment)) {
                return new int[] {i , map.get(compliment)};
            }
            map.put(arr[i] , i);
        }
        return new int[] {-1,-1};

    }
}
