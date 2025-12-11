package day10;

import java.util.Set;
import java.util.TreeSet;

class Ex03 {
    public int[] solution(int[] arr, int divisor) {
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