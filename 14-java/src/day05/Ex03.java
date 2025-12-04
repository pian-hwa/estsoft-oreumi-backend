package day05;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int number = in.nextInt();
        System.out.println();

        in.close();

        printDevisors(number);
    }

    public static void printDevisors(int number) {
        System.out.printf("Devisors of %d =", number);

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                System.out.printf(" %d", i);
            }
        }

        System.out.println();
    }
}