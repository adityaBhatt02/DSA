package Array;

import java.util.Arrays;
import java.util.Scanner;

public class FashionableArray {
     static int minRemovals(int[] arr) {
            int n = arr.length;

            int min = Arrays.stream(arr).min().getAsInt();
            int max = Arrays.stream(arr).max().getAsInt();

            // Already fashionable
            if ((min + max) % 2 == 0) return 0;

            // Try removing one element
            for (int i = 0; i < n; i++) {
                int[] newArr = new int[n - 1];
                int idx = 0;
                for (int j = 0; j < n; j++) {
                    if (j != i) newArr[idx++] = arr[j];
                }
                int newMin = Arrays.stream(newArr).min().getAsInt();
                int newMax = Arrays.stream(newArr).max().getAsInt();
                if ((newMin + newMax) % 2 == 0) return 1;
            }

            // Otherwise at most 2 removals are needed
            return 2;
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while (t-- > 0) {
                int n = sc.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                System.out.println(minRemovals(arr));
            }

            sc.close();
        }
}
