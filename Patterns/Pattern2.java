package Patterns;

import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        pattern1(n);
        pattern2(n);
    }

    static void pattern1(int n) {
        int sp = n - 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sp; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= n - sp; k++) {
                System.out.print("* ");
            }
            sp--;
        System.out.println();
        }
    }
        
    static void pattern2(int n) {
        int sp = 0;
        int str = n;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sp ; j++) {
                System.out.print("  ");
            }
            for (int k = 1; k <= str; k++) {
                System.out.print("* ");
            }
            sp++;
            str--;
            System.out.println();
        }
    }
}
