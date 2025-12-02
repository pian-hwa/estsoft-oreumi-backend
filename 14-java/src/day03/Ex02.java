package day03;

public class Ex02 {
    public static void main(String[] args) {
        final int NUM = 10;

        for (int i = NUM; i > 0; i--) {
            for (int j = 1; j <= NUM - 1; j++) {
                System.out.print(j < i ? " " : "*");
            }

            System.out.print("*");

            for (int j = NUM - 1; j > 0; j--) {
                System.out.print(j < i ? " " : "*");
            }

            System.out.println();
        }
    }
}
