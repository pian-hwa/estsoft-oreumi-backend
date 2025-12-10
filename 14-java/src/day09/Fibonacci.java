package day09;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        int num;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        num = in.nextInt();
        System.out.println();

        in.close();

        try {
            System.out.printf("%dth Fibonacci number = %d\n", num, fibonacci(num));
        }  catch (IllegalArgumentException e) {
            System.err.println("ERROR: " + e.getMessage());
        }
    }

    public static long fibonacci(int n) {
        if (n < 0)
            throw new IllegalArgumentException("Please enter a positive integer.");

        long[] cache = new long[n + 1];
        return logic(n, cache);
    }

    private static long logic(int n, long[] cache) {
        if (cache[n] != 0) return cache[n];
        if (n <= 1) return n;

        cache[n] = logic(n - 1, cache) + logic(n - 2, cache);
        return cache[n];
    }
}