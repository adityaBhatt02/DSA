package Patterns;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    static void pattern(int n) {
        int str = n/2 + 1;
        int sp = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= str ; j++) {
                System.out.print("*\t");
            }
            for (int k = 1; k <= sp ; k++) {
                System.out.print("\t");
            }
            for (int l = 1; l <= str; l++) {
                System.out.print("*\t");
            }

            if(i <= n/2) {
                str--;
                sp += 2;
            }else {
                str++;
                sp -= 2;
            }
            System.out.println();
        }
    }
}
