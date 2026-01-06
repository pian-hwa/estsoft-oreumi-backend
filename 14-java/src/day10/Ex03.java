package day10;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

class Ex03 {
    public static void main(String[] args) {
        int[] array = { 5, 9, 7, 10 };

        long startTime = System.nanoTime();
        int[] result = solution(array, 5);
        System.out.printf("runtime = %.3fms\n",
                (System.nanoTime() - startTime) / 1000000.0);
        System.out.println(Arrays.toString(result));

        System.out.println();
    }

    public static int[] solution(int[] arr, int divisor) {
        Set<Integer> answer = new TreeSet<>();

        for (int a : arr) {
            if (a % divisor == 0)
                if (!answer.add(a)) break;
        }

        if (answer.isEmpty()) {
            return new int[] { -1 };
        }

        return answer.stream().mapToInt(x -> x).toArray();
    }
}