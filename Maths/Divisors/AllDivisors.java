package Maths.Divisors;

/*
eg:
n = 36
(then 36 is divisible by 1,2,3,4,6,9,12,16,36 so total of 9 divisors)
 */

import java.util.ArrayList;
import java.util.List;

public class AllDivisors {
    public List<Integer> divisors(int n) {
        List<Integer> result = new ArrayList<>();
        int sqrt = (int) Math.sqrt(n);

        for (int i = 1 ; i <= sqrt ; i++) {                  // only to run till square root of "n" to reduce time complexity from n to n/2
            if(n % i == 0) {
                result.add(i);
                if(n / i != i) result.add(n/i);              // if condition so that duplicates not get added
            }
        }
        return result;
    }
}
