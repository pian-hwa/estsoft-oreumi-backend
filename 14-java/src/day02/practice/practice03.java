package day02.practice;

public class practice03 {
    public static void main(String[] args) {
        int money = 50000;
        double cs = money;
        double yh = money;
        int year = 1;

        while (cs >= yh) {
            cs += money * 0.05;
            yh *= 1.03;
            year++;
        }

        System.out.println("The year is = " + year);
    }
}