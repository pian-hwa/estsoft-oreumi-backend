package day05;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter two integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        System.out.println();

        in.close();

        System.out.printf("The average of %d and %d = %.1f\n", n1, n2, getAverage(n1, n2));
    }

    public static double getAverage(int n1, int n2) {
        return (n1 + n2) / 2.0;
    }
}