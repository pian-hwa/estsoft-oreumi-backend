package day04.practice;

public class practice01 {
    public static void main(String[] args) {
        int[][] scores = {
                { 87, 43, 64, 71 },
                { 65, 69, 77, 82 },
                { 91, 84, 62, 76 }
        };
        int[] sum = new int[scores[0].length];

        for (int i = 0; i < scores[0].length; i++) {
            if (i == 0) System.out.print("1st col: sum = ");
            else if (i == 1) System.out.print("2nd col: sum = ");
            else if (i == 2) System.out.print("3rd col: sum = ");
            else System.out.printf("%dth col: sum = ", i + 1);

            sum[i] = 0;

            for (int j = 0; j < scores.length; j++) {
                sum[i] += scores[j][i];
            }

            System.out.printf("%d, average = %.2f\n", sum[i], (double)sum[i] / scores.length);
        }
    }
}