package day04;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        final int LENGTH = 10;
        int[] num = new int[LENGTH];

        int sum = 0;
        double average;
        int max = 0;

        Scanner in =  new Scanner(System.in);

        for (int n : num) {
            System.out.print("Enter an integer: ");
            num[n] = in.nextInt();

            sum += num[n];
            max = Math.max(max, num[n]);
        }

        in.close();

        average = (double)sum / LENGTH;

        System.out.println();

        System.out.println("sum = " + sum);
        System.out.println("average = " + average);
        System.out.println("max = " + max);
    }
}
