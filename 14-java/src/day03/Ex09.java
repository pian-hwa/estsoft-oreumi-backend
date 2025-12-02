package day03;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        int n1, n2;
        int count = 0;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter two positive integers: ");
        n1 = in.nextInt();
        n2 = in.nextInt();

        in.close();

        System.out.println();

        System.out.printf("Multiples of %d between 1 and %d =",  n2, n1);

        for (int i = n2; i <= n1; i += n2, count++) {
            System.out.printf(" %d", i);
        }

        System.out.println();
        System.out.printf("Number of multiples of %d = %d\n", n2, count);
    }
}
