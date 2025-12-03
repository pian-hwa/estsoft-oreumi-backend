package day04;

public class Ex12 {
    public static void main(String[] args) {
        int[][] scores = {
            { 87, 43, 64, 71 },
            { 65, 69, 77, 82 },
            { 91, 84, 62, 76 }
        };
        int[] sum = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            if (i == 0) System.out.print("1st row: sum = ");
            else if (i == 1) System.out.print("2nd row: sum = ");
            else if (i == 2) System.out.print("3rd row: sum = ");
            else System.out.printf("%dth row: sum = ", i + 1);

            sum[i] = 0;

            for (int j = 0; j < scores[i].length; j++) {
                sum[i] += scores[i][j];
            }

            System.out.printf("%d, average = %.2f\n", sum[i], (double)sum[i] / scores[i].length);
        }
    }
}