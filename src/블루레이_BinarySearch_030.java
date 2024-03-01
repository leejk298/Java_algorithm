import java.util.Scanner;

public class 블루레이_BinarySearch_030 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 크기
        int M = sc.nextInt(); // 블루레이 개수
        int A[] = new int[N]; // 배열
        int S = 0, E = 0; // 시작, 끝

        for (int i = 0; i < N; i++) { // 크기만큼
            A[i] = sc.nextInt(); // 배열저장

            if (S < A[i]) // 시작
                S = A[i]; // 가장 큰 수

            E = E + A[i]; // 끝은 모든 수의 합
        }

        while (S <= E) {
            int mid = (S + E) / 2; // 중앙값
            int sum = 0, cnt = 0;

            for (int i = 0; i < N; i++) { // 크기만큼
                if (sum + A[i] > mid) { // 중앙값보다 크면 짜르기
                    cnt++; // 블루레이 개수 카운트
                    sum = 0; // 합은 초기화
                }

                sum += A[i]; // 작으면 계속 더해줌
            }

            if (sum != 0) // 마지막에 sum이 0 아니면 더 있으므로
                cnt++; // 블루레이 개수 카운트

            if (cnt > M) // 블루레이 개수보다 많으면
                S = mid + 1; // S 설정

            else // 작으면
                E = mid - 1; // E 설정
        }

        System.out.println(S); // 반복문 탈출 => (S > E)이므로 S 출력
    }
}
