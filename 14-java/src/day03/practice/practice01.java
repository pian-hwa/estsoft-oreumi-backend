package day03.practice;

import java.util.Scanner;

public class practice01 {
    public static void main(String[] args) {
        int num;
        boolean isPrime = true;

        Scanner in =  new Scanner(System.in);

        System.out.print("Enter a positive integer greater than 1: ");
        num = in.nextInt();
        System.out.println();

        in.close();

        for (int i = 2; i < num; i++) {
            if (num % i == 0) isPrime = false;
        }

        System.out.println(num + (isPrime ? " is a prime number." : " is not a prime number."));
    }
}