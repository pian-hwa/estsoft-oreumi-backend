package day04;

public class Ex11 {
    public static void main(String[] args) {
        int[][] numbers = {
            { 1, 2, 3, 4 },
            { 5, 6, 7, 8 },
            { 9, 10, 11, 12 },
        };

        for (int[] num : numbers) {
            for (int i : num) {
                System.out.printf("%2d ", i);
            }
            System.out.println();
        }

    }
}
