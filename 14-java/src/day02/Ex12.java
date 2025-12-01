package day02;

import java.util.Scanner;

public class Ex12 {
    public static void main(String[] args) {
        long factorial = 1;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = in.nextInt();

        in.close();

        for (int i = num; i > 0; i--) {
            factorial *= i;
        }

        System.out.printf("Factorial %d = %d", num, factorial);
    }
}
