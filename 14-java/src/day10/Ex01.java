package day10;

public class Ex01 {
    public static void main(String[] args) {
        System.out.println(getEpisode(10));
    }

    private static int getEpisode(int n) {
        int number = 0;
        int count = 0;

        if (n <= 0) return 0;

        for (int i = 1; count < n; i++) {
            String toStr = String.valueOf(i);
            if (toStr.contains("666")) {
                number = i;
                count++;
            }
        }

        return number;
    }
}