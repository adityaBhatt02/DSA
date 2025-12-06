package Patterns;

import java.util.Scanner;

public class Pattern1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pattern1(n);
        System.out.println();
        pattern2(n);
    }

    static void pattern1(int n) {
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for(int i = 1 ; i <= n ; i++) {
            for(int j = i ; j <= n ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
