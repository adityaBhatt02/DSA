package Maths.Divisors;

import java.util.ArrayList;
import java.util.List;

public class FourDivisors {
        public int sumFourDivisors(int[] nums) {
            int total = 0;
            for(int num : nums) {
                int count = 0;
                int length = (int) Math.sqrt(num);
                List<Integer> list = new ArrayList<>();

                for(int i = 1 ; i <= length ; i++){
                    if(num % i == 0) {
                        count++;
                        list.add(i);
                        if(num / i != i) {
                            count++;
                            list.add(num/i);
                        }
                    }
                }
                int sum = 0;
                if(count == 4) {
                    for(int div : list) {
                        sum += div;
                    }
                    total += sum;
                }
            }

            return total;
        }
    }
