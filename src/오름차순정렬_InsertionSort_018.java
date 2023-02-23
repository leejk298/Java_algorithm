import java.util.Scanner;

public class 오름차순정렬_InsertionSort_018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기
        int A[] = new int[N]; // 입력 배열
        int S[] = new int[N]; // 합 배열

        for (int i = 0; i < N; i++) // N 만큼
            A[i] = sc.nextInt(); // 저장

        for (int i = 1; i < N; i++) { // 1 ~ N까지 => 정렬할 구간
            int insert_point = i; // 삽입할 곳
            int insert_value = A[i]; // 삽입할 값

            for (int j = i - 1; j >= 0; j--) { // 탐색할 구간
                if (A[j] < A[i]) { // 작으면
                    insert_point = j + 1; // 갱신 위치 설정

                    break;
                }

                if (j == 0) // 0이면
                    insert_point = 0; // 없으므로 처음
            }

            for (int j = i; j > insert_point; j--) // 삽입할 위치 만들기 -> 위치 갱신
                A[j] = A[j - 1];

            A[insert_point] = insert_value; // 해당 위치에 삽입
        }

        S[0] = A[0]; // 합 배열 만들기
        for (int i = 1; i < N; i++)
            S[i] = S[i - 1] + A[i];

        int sum = 0;
        for (int i = 0; i < N; i++)
            sum = sum + S[i];

        System.out.println(sum);
    }
}
