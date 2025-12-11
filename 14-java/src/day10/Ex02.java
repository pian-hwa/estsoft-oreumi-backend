package day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02 {
    private static int max = 0;
    private static List<Integer> resultCards = new ArrayList<>();

    public static void main(String[] args) {
        final int LENGTH = 5;
        int[] cards = new int[LENGTH];
        Scanner in = new Scanner(System.in);

        System.out.print("Enter five card numbers: ");
        for (int i = 0; i < LENGTH; i++) {
            cards[i] = in.nextInt();
        }
        System.out.println();

        in.close();

        result(cards, new ArrayList<>(), 0, 0);

        System.out.print("Cards:");

        for (int card : resultCards) {
            System.out.printf(" %d",  card);
        }

        System.out.println();
        System.out.println("Sum: " + max);
    }

    // 재귀로 조합 탐색
    static void result(int[] cards, List<Integer> process, int index, int sum) {
        if (sum > 21) return;

        if (index == cards.length) {
            if (sum > max) {
                max = sum;
                resultCards = new ArrayList<>(process);
            }
            return;
        }

        process.add(cards[index]);
        result(cards, process, index + 1, sum + cards[index]);
        process.removeLast();

        result(cards, process, index + 1, sum);
    }
}