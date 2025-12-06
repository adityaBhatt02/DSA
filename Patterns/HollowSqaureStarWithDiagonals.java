package Patterns;

import java.util.Scanner;

public class HollowSqaureStarWithDiagonals {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        if (n < 1) {
            System.out.println("Enter a number >= 1");
            return;
        }
        pattern(n);
    }

    static void pattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j || i+j == n+1 || i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*\t");
                }else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }

    }
}
