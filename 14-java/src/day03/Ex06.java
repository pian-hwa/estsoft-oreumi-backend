package day03;

import java.util.Scanner;

public class Ex06 {
    public static void main(String[] args) {
        int height, rise, sliding;
        int current = 0;
        int day;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the tree height: ");
        height = in.nextInt();

        System.out.print("Enter the height that rises during the day: ");
        rise = in.nextInt();

        System.out.print("Enter the sliding height at night: ");
        sliding = in.nextInt();
        System.out.println();

        in.close();

        for (day = 0; current < height; day++) {
            current += rise;

            if (!(current >= height)) current -= sliding;
        }

        System.out.printf("It takes %d days for the snail to climb the tree.\n", day);
    }
}
