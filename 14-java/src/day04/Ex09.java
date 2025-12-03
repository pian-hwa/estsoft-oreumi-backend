package day04;

public class Ex09 {
    public static void main(String[] args) {
        boolean isPrime = true;

        System.out.println("Prime numbers between 2 and 100: ");

        for (int i = 2; i <= 100; i++) {
            isPrime = true;

            for (int j = 2; j < Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) System.out.print(i + " ");
        }

        System.out.println();
    }
}
