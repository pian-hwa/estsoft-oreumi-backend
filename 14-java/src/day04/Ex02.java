package day04;

import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        int n1, n2, max, min, temp;
        Scanner in =  new Scanner(System.in);

        System.out.print("Enter two positive integers: ");
        n1 =  in.nextInt();
        n2 =  in.nextInt();
        System.out.println();

        in.close();

        max = Math.max(n1, n2);
        min = Math.min(n1, n2);

        while(min > 0) {
            temp = min;
            min = max % min;
            max = temp;
        }

        System.out.printf("The greatest common factor of %d and %d = %d\n", n1, n2, max);
    }
}
