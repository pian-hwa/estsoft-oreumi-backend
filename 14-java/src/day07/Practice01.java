package day07;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Practice01 {
    public static void main(String[] args) {
        int korean, math, english;
        double average;
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter Korean score: ");
                korean = in.nextInt();

                System.out.print("Enter Math score: ");
                math = in.nextInt();

                System.out.print("Enter English score: ");
                english = in.nextInt();
                System.out.println();

                if (korean < 0 || math < 0 || english < 0)
                    throw new NegativeScoreException();

                if (korean > 100 || math > 100 || english > 100)
                    throw new InvalidScoreException();

                average = (korean + math + english) / 3.0;
                System.out.printf("Average: %.1f\n", average);
                break;

            } catch (NegativeScoreException | InvalidScoreException e) {
                System.out.println("ERROR: " + e.getMessage()); // 문제: System.err.println() 으로 출력하면 출력 순서가 밀리는 것을 확인. -> 해결: System.out.println() 으로 출력.
                System.out.println("Try again.");
                System.out.println();
            } catch (InputMismatchException e) {
                System.out.println();   // 앞선 System.out.println() 이 출력되기 전에 출력되는 오류임으로 개행 추가
                System.out.println("ERROR: Wrong input entered.");  // e.getMessage() 가 null 로 정의되지 않았음으로 직접 출력.

                System.out.println("Try again.");
                System.out.println();
                in.nextLine();      // 버퍼를 비워야 입력되었던 오류 값이 해제됨.
            }
        }

        in.close();
    }
}
