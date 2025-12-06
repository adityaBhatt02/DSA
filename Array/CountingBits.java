package Array;

/*
isme ye hae ke first of all you have to return an array of size n + 1
then inside it for eg : n = 5 then the array is n + 1 => 6 {0 , 1 , 2 ..... , 5} indexes
then for each index we have to tell how many 1's are there in there binary representation.
 */

public class CountingBits {
        public int[] countBits(int n) {
            int[] arr = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                int count = 0;
                int x = i;
                while (x > 0) {
                    count += x % 2;                     // simple yaad rkho % by 2 with even 0 he dega odd 1 dega
                    x /= 2;
                }
                arr[i] = count;
            }
            return arr;
        }
    }