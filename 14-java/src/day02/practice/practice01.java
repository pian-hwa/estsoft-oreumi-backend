package day02.practice;

import java.util.Scanner;

public class practice01 {
    public static void main(String[] args) {
        int wage;
        int hour;
        double today;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter hourly wage: ");
        wage = in.nextInt();

        System.out.print("Enter the hours worked: ");
        hour = in.nextInt();
        System.out.println();

        in.close();

        today = (hour > 8) ? wage * (8 + (hour - 8) * 1.5) : wage * hour;

        System.out.printf("Today's wage is %d won.", (int)today);

    }
}