package day09;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int num;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();

        in.close();

        try {
            System.out.printf("Factorial %d = %d\n", num, factorial(num));
        }  catch (IllegalArgumentException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static long factorial(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Please enter a positive integer.");

        return n <= 1 ? 1 : n * factorial(n - 1); // 찾아보니 0 팩토리얼은 1이라는 정의가 있었음.
    }
}