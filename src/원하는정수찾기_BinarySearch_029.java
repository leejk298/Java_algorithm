import java.util.Arrays;
import java.util.Scanner;

public class 원하는정수찾기_BinarySearch_029 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기
        int A[] = new int[N]; // 배열

        for (int i = 0; i < N; i++) // 크기만큼
            A[i] = sc.nextInt(); // 배열 저장

        Arrays.sort(A); // 이진탐색은 정렬되어있는 상태에서 수행함 => quickSort 내장: O(NlogN)

        int M = sc.nextInt(); // 찾을 개수

        for (int i = 0; i < M; i++) { // 찾을 개수만큼
            boolean flag = false;
            int t = sc.nextInt(); // 찾아야할 숫자
            int S = 0, E = N - 1; // 시작, 끝

            while (S <= E) {
                int mid_idx = (S + E) / 2; // 중앙 index
                int mid_value = A[mid_idx]; // 중앙 값

                if (mid_value < t) // 중앙 값보다 크면
                    S = mid_idx + 1; // S 설정

                else if (mid_value > t) // 작으면
                    E = mid_idx - 1; // E 설정

                else // 같으면
                {
                    flag = true; // 찾았으므로 탐색 성공

                    break; // while 반복문 종료
                }
            }

            if (flag) // true면
                System.out.println(1); // 1 출력
            else // false면
                System.out.println(0); // 0 출력
        }

    }
}
