package day09;

import java.util.Scanner;

public class practice01 {
    public static void main(String[] args) {
        int n1, n2;
        Scanner in =  new Scanner(System.in);

        System.out.print("Enter two positive integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();
        System.out.println();

        in.close();

        try {
            System.out.printf("The greatest common divisor of %d and %d = %d\n", n1, n2, getGcd(n1, n2));
            System.out.printf("The least common multiple of %d and %d = %d\n", n1, n2, n1 * n2 / getGcd(n1, n2));
        } catch (IllegalArgumentException e) {
            System.err.println("ERROR: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int getGcd(int n1, int n2) {
        if (n1 <= 0 || n2 <= 0)
            throw new IllegalArgumentException("Please enter positive integers.");

        return n1 % n2 == 0 ? n2 : getGcd(n2, n1 % n2);
    }
}