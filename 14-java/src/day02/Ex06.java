package day02;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        int max;
        int min;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter two integers: ");
        int n1 = in.nextInt();
        int n2 = in.nextInt();

        if (n1 > n2) {
            max = n1;
            min = n2;
        } else {
            max = n2;
            min = n1;
        }

        System.out.println("max - min = " + (max - min));
    }
}
