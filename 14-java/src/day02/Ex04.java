package day02;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        int quotient;
        int remainder;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter two positive integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        in.close();

        quotient = n1 / n2;
        remainder = n1 % n2;

        System.out.println("Quotient  = " +  quotient);
        System.out.println("Remainder = " + remainder);
    }
}