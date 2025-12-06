package Maths.Divisors;

public class ThreeDivisors {
        public boolean isThree(int n) {
            int count = 0;
            int length = (int) Math.sqrt(n);

            for(int i = 1 ; i <= length ; i++) {
                if(n % i == 0) {
                    count++;
                    if(n / i != i) count++;
                }
            }
            return count == 3;
        }
    }
