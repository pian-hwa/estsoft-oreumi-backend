package day04;

import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        int n1, n2, min;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter two positive integers: ");
        n1 =  in.nextInt();
        n2 =  in.nextInt();
        System.out.println();

        in.close();

        min = Math.min(n1, n2);

        for (int i = min; i > 0; i--) {
            if (n1 % i == 0 && n2 % i == 0) {
                System.out.printf("The greatest common factor of %d and %d = %d\n", n1, n2, i);
                break;
            }
        }
    }
}
