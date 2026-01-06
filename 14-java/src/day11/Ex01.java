package day11;

import java.util.Arrays;

public class Ex01 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
    }

    /* 기존 생각 (글자가 커지면 비효율적, 시간 복잡도 제곱)
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int distance = -1;

            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    distance = i - j;
                    break;
                }
            }

            answer[i] = distance;
        }

        return answer;
    }
    */

    // 로직 자체를 수정 -> 영문자 소문자만 한정했을 때 가능한 방법
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] lastIndex = new int[26];
        Arrays.fill(lastIndex, -1);

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            answer[i] = lastIndex[index] == -1 ? -1 : i - lastIndex[index];
            lastIndex[index] = i;
        }

        return answer;
    }
}