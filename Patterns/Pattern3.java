package Patterns;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern(n);
    }

    static void pattern(int n) {
        int sp = n/2;
        int str = 1;

        for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sp; j++) {
                    System.out.print("  ");
                }
                for (int k = 1; k <= str; k++) {
                    System.out.print("* ");
                }
                for (int l = 1; l <= sp; l++) {
                    System.out.print("  ");
                }

                if(i <= n/2) {
                    str += 2;
                    sp--;
                }else {
                    str -= 2;
                    sp++;
                }
                System.out.println();
            }
        }
}
