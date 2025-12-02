package day03;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        int num;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int count = 0;

        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a positive integer: ");
            num = in.nextInt();

            if (num == 0) break;

            max = Math.max(max, num);
            min = Math.min(min, num);

            sum += num;
            count++;
        }

        System.out.println();

        if (count > 0) {
            System.out.println("The maximum number: " + max);
            System.out.println("The minimum number: " + min);
            System.out.println("The average is " + (double)sum / count);
        } else {
            System.out.println("ERROR: You must enter positive integer.");
        }

        in.close();
    }
}
