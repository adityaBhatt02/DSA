package Patterns;

import java.util.Scanner;

public class Diagonals {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
//        pattern1(n);
//        pattern2(n);
        pattern3(n);
    }

    static void pattern1(int n) {
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i == j) {
                    System.out.print("*\t");
                }else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if((i + j) == n + 1){
                    System.out.print("*\t");
                }else{
                    System.out.print("\t");
                }
            }
                System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i == j || i+j == n+1) {
                    System.out.print("*\t");
                }else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
