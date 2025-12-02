package day03.practice;

import java.util.Scanner;

public class practice02 {
    public static void main(String[] args) {
        int weight, temp;
        int bags = 0;

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the weight of sugar to be delivered: ");
        weight = in.nextInt();
        System.out.println();

        in.close();

        temp = weight;

        while (temp >= 0) {
            if (temp % 5 == 0) {
                bags += temp / 5;
                break;
            }

            if (temp < 3) {
                bags = 0;
                break;
            } else {
                temp -= 3;
                bags++;
            }
        }

        if (bags > 0) System.out.printf("Cheolsu will need to bring %d bags.\n", bags);
        else System.out.printf("Cheolsu cannot take %dkg of sugar.\n", weight);
    }
}