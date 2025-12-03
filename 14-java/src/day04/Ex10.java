package day04;

public class Ex10 {
    public static void main(String[] args) {
        final int NUM = 100;
        boolean[] isPrime = new boolean[NUM + 1];

        for (int i = 2; i <= NUM; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= NUM; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        System.out.printf("Prime numbers between 2 and %d:\n", NUM);
        for (int i = 2; i <= 100; i++) {
            if (isPrime[i]) System.out.print(i + " ");
        }
        System.out.println();
    }
}
