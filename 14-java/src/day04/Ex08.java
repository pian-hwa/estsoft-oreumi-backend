package day04;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {
        int coin500 = 0;
        int coin100 = 0;
        int coin50 = 0;
        int coin10 = 0;

        int amount;

        Scanner in =  new Scanner(System.in);

        System.out.print("Enter the amount to be repaid: ");
        amount = in.nextInt();
        System.out.println();

        in.close();

        for (int i = 0; i <= amount; i++) {
            if (amount > 500 && coin500 < 10) {
                amount -= 500;
                coin500++;
            } else if (amount > 100 && coin100 < 10) {
                amount -= 100;
                coin100++;
            } else if (amount > 50 && coin50 < 10) {
                amount -= 50;
                coin50++;
            } else if (amount > 10 && coin10 < 10) {
                amount -= 10;
                coin10++;
            }
        }

        if (coin500 != 0) System.out.println("500 won coins = " + coin500);
        if (coin100 != 0) System.out.println("100 won coins = " + coin100);
        if (coin50 != 0) System.out.println("50 won coins = " + coin50);
        if (coin10 != 0) System.out.println("10 won coins = " + coin10);

    }
}
