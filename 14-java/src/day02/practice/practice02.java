package day02.practice;

import java.util.Scanner;

public class practice02 {
    public static void main(String[] args) {
        int num;
        int digit = 1;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();

        in.close();

        while (num > 0) {
            System.out.printf("%d's digit = %d\n", digit, num % 10);
            num /= 10;
            digit *= 10;
        }
    }
}
