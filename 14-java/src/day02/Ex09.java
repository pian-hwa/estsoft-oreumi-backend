package day02;

import java.util.Scanner;

public class Ex09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter two integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        System.out.println();
        System.out.printf("n1 = %d, n2 = %d\n", n1, n2);

        in.close();

        int store = n1;
        n1 = n2;
        n2 = store;

        System.out.printf("n1 = %d, n2 = %d\n", n1, n2);
    }
}
