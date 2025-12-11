package day10;


public class Ex04 {
    public int[] solution(int[] arr) {
        if (arr.length == 0) return arr;

        int length = 1;

        for (int i = 1; i < arr.length; i++)
            if (arr[i] != arr[i - 1]) arr[length++] = arr[i];

        int[] answer = new int[length];
        System.arraycopy(arr, 0, answer, 0, length);

        return answer;
    }
}