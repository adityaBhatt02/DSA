package Array;

import java.util.HashSet;
import java.util.Set;

public class isDuplicate {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,4,5,5};
        System.out.println(isDupli(arr));
    }

    static boolean isDupli(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int num : arr) {
            /*
            if the element is not present it adds and return true but if it's a duplicate it will not add
             that element(ignores) it and return false.
             */
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
