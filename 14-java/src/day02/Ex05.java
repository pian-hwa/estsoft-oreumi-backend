package day02;

import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int num = in.nextInt();

        in.close();

        if (num > 20 && num < 40) System.out.println("Dream comes true!");
    }
}
