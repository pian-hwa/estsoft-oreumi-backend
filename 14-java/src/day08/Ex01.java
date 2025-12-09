package day08;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class Ex01 {
    public static void main(String[] args) {

        final int LENGTH = 6;
        final int MAX = 45;
        int[] lotto = new int[LENGTH];
        Random number = new Random();

        for (int i = 0; i < LENGTH; ) {
            int value = number.nextInt(45) + 1;

            if (!contains(lotto, value)) lotto[i++] = value;
        }

        Arrays.sort(lotto);

        System.out.print("Lotto:");
        for (int item : lotto) {
            if (item < 10) System.out.print(" 0");
            else System.out.print(" ");
            System.out.printf("%d", item);
        }
        System.out.println();
    }

    private static Boolean contains (int[] array, int number) {
        for (int n : array) {
            if (n == number) return true;
        }

        return false;
    }
}
