package day01;

public class Ex01 {
    public static void main(String[] args) {
        int value = 100;
        double factor = 0.98;
        char grade = 'A';

        System.out.println("Value: " + value + ", Factor: " + factor + ", Grade: " + grade);
        System.out.printf("Value: %d, Factor: %f, Grade: %c\n", value, factor, grade);
        System.out.printf("Value: %d, Factor: %.2f, Grade: %c\n", value, factor, grade);
    }
}