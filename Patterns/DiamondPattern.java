package Patterns;

import java.util.Scanner;

public class DiamondPattern {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        // pyramid ->
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= n - i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1 ; k <= 2 * i - 1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // inverted-pyramid ->
        for(int i = n - 1 ; i >= 1 ; i--) {
            for(int j = 1 ; j <= n - i ; j++) {
                System.out.print(" ");
            }
            for (int k = 1 ; k <= 2 * i - 1 ; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
