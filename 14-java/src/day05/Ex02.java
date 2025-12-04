package day05;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        Scanner in =  new Scanner(System.in);

        System.out.print("Enter your favorite number: ");
        int number = in.nextInt();
        System.out.println();

        in.close();

        printNumber(number);
    }

    public static void printNumber(int number) {
        System.out.printf("Your favorite number is %d.\n", number);
    }
}