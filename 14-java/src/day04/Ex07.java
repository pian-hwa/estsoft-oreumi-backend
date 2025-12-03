package day04;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        int[] numbers = new int[10];
        int[] rs = new int[10];
        int count = 0;
        int length;
        boolean isFound = false;

        Scanner in =  new Scanner(System.in);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter a positive integer: ");
            numbers[i] = in.nextInt();
        }

        in.close();

        for (length = 0; length < numbers.length; length++) {
            isFound = false;

            for (int j = 0; j < count; j++) {
                if (numbers[length] % 19 == rs[j]) {
                    isFound = true;
                    break;
                }
            }

            if (!isFound) {
                rs[count] = numbers[length] % 19;
                count++;
            }
        }

        System.out.println();
        System.out.printf("Number of different remainders is %d.\n", count);
    }
}
