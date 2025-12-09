package day08;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ex02 {
    public static void main(String[] args) {
        final int LENGTH = 6;
        final int MAX = 45;
        Set<Integer> lotto = new TreeSet<>();
        Random rand = new Random();

        while (lotto.size() < LENGTH) {
            lotto.add(rand.nextInt(MAX) + 1);
        }

        System.out.print("Lotto:");
        for (int item : lotto) {
            if (item < 10) System.out.print(" 0");
            else System.out.print(" ");
            System.out.printf("%d", item);
        }
        System.out.println();
    }
}