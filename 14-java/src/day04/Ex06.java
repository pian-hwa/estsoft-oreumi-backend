package day04;

public class Ex06 {
    public static void main(String[] args) {
        int[] numbers = { 1, 3, 4, 3, 1, 3, 4, 1, 2, 3, 1, 3 };

        for (int i = 0; i < 4; i++) {
            System.out.print(i + 1 + ". ");

            for (int n : numbers) {
                if (n == i + 1) System.out.print("*");
            }

            System.out.println();
        }
    }
}
