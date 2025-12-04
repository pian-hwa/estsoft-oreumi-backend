package day05;

import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        int radius = in.nextInt();
        System.out.println();

        in.close();

        System.out.printf("Area of the circle with radius %d = %.3f\n", radius, getAreaCircle(radius));
    }

    public static double getAreaCircle(int radius) {
        return Math.PI * radius * radius;
    }
}
