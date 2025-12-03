package day04.practice;

import java.util.Scanner;

public class practice02 {
    public static void main(String[] args) {
        int num;
        int[] binary = new int[32];
        int index;

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an integer: ");
            num = in.nextInt();

            if (num == 0) break;

            System.out.printf("The binary number for decimal %d is ", num);

            for (index = 1; num > 0; index++) {
                binary[index - 1] = num % 2;
                num /= 2;
            }

            for (int i = index - 2; i >= 0; i--) {
                System.out.print(binary[i]);
            }

            System.out.println(".");
            System.out.println();
        }

        System.out.println("Good bye!");

        in.close();
    }
}
