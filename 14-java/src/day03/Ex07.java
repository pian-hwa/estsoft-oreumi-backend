package day03;

import java.util.Scanner;

public class Ex07 {
    public static void main(String[] args) {
        int num;
        int hours, minutes;

        Scanner in =  new Scanner(System.in);

        while (true) {
            System.out.printf("Enter minutes: ");
            num = in.nextInt();

            if (num == 0) break;

            hours = num / 60;
            minutes = num % 60;

            if (hours != 0 && minutes != 0) System.out.printf("%d minutes = %d hour %d minutes\n\n", num, hours, minutes);
            else if (hours == 0 && minutes != 0) System.out.printf("%d minutes = %d minutes\n\n", num, minutes);
            else if (hours != 0) System.out.printf("%d minutes = %d hour\n\n", num, hours);
        }

        System.out.println("Good bye!");

        in.close();
    }
}
