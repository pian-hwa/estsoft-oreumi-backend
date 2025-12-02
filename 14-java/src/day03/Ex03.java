package day03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {

        int rows;
        int cols;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        rows = in.nextInt();
        System.out.print("Enter the number of columns: ");
        cols = in.nextInt();
        System.out.println();

        in.close();

        System.out.println("========Type 01========\n");

        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.printf("%2d ", i * cols + j + 1);
            }

            System.out.println();
        }

        System.out.println();

        System.out.println("========Type 02========\n");
        for (int i = 1; i <= rows; i++) {
            for(int j = 1; j <= cols; j++) {
                System.out.printf("%2d ", i + rows * (j - 1));
            }

            System.out.println();
        }
    }
}