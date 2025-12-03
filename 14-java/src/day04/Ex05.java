package day04;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        final int LENGTH = 30;
        int[] numbers = new int[LENGTH];

        int sum = 0;
        double average;
        int length;
        int count = 0;

        Scanner in = new Scanner(System.in);

        for (length = 0; length < LENGTH; length++) {
            System.out.print("Enter an integer: ");
             numbers[length] = in.nextInt();

            if (numbers[length] == 0) break;

            sum += numbers[length];
        }

        average = (double)sum / length;

        for (int i = 0; i < length; i++) {
            if (numbers[i] > average) count++;
        }

        System.out.println();
        System.out.println("average = " + average);
        System.out.printf("percentage of integers above the average = %.2f%%\n", (double)count / length * 100);

        in.close();
    }
}