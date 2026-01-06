package day10;


import java.util.Arrays;
import java.util.stream.IntStream;

public class Ex04 {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 2, 5, 6, 6, 1, 6, 1, 1, 1 };

        System.out.println(Arrays.toString(solution2(arr)));
    }

    public int[] solution(int[] arr) {
        if (arr.length == 0) return arr;

        int length = 1;

        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i - 1]) arr[length++] = arr[i];

        int[] answer = new int[length];
        System.arraycopy(arr, 0, answer, 0, length);

        return answer;
    }

    public static int[] solution2(int[] arr) {
        return IntStream.range(0, arr.length)
                .filter(i -> i == 0 || arr[i] != arr[i - 1])
                .map(i -> arr[i])
                .toArray();
    }
}