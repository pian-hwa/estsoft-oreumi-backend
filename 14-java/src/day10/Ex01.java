package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = in.nextInt();
        in.close();

        long startTime = System.nanoTime();
        System.out.printf("The number included in the %dth episode title = %d\n",
                n, getEpisode(n));
        System.out.printf("runtime = %.3fms\n",
                (System.nanoTime() - startTime) / 1000000.0);
        System.out.println();

        startTime = System.nanoTime();
        System.out.printf("The number included in the %dth episode title = %d\n",
                n, getEpisode(n));
        System.out.printf("runtime = %.3fms\n",
                (System.nanoTime() - startTime) / 1000000.0);
        System.out.println();
    }

    private static long getEpisode(int n) {
        int count = 0;

        if (n <= 0) return 0;

        for (int i = 1; true; i++) {
            String toStr = String.valueOf(i);
            if (toStr.contains("666")) {
                count++;
                if (count == n) return i;
            }
        }
    }

    private static long getEpisode2(int n) {
        int count = 0;

        if (n <= 0) return 0;

        for (int i = 666; true; i++) {
            if (check(i)) {
                count++;
                if (count == n) return i;
            }
        }
    }

    private static boolean check(int n) {
        while(n >= 666) {
            if (n % 1000 == 666) return true;
            n /= 10;
        }
        return false;
    }
}