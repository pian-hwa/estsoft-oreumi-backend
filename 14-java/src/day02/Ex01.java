package day02;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter two integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();
        in.close();

        System.out.println("n1 = " + n1);
        System.out.println("n2 = " + n2);
    }
}