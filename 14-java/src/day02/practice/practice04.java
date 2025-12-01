package day02.practice;

import java.util.Scanner;

public class practice04 {
    public static void main(String[] args) {
        int num;
        int fibo1 = 0;
        int fibo2 = 1;

        Scanner in =  new Scanner(System.in);

        System.out.print("Enter a positive integer greater than 1: ");
        num = in.nextInt();
        System.out.println();

        in.close();


        for  (int i = 2; i <= num; i++) {
            int  temp = fibo1 + fibo2;
            fibo1 = fibo2;
            fibo2 = temp;
        }

        System.out.printf("%dth Fibonacci number = %d\n", num, fibo2);
    }
}
