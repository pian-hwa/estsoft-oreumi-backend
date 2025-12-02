package day03;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        System.out.println();

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = in.nextInt();
        System.out.println();

        in.close();

        for (int i = rows; i > 0; i--) {
            for (int j = 1; j <= rows; j++) {
                System.out.print(j < i ? " " : "*");
            }
            System.out.println();
        }
    }
}
