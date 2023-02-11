import java.util.Scanner;

public class 동전개수_최솟값_Greedy_032 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int N = sc.nextInt(); // 동전 개수
        int K = sc.nextInt(); // 비용
        int A[] = new int[N]; // 배열

        for (int i = 0; i < N; i++) // N 만큼
            A[i] = sc.nextInt(); // 배열 저장

        int cnt = 0; // 동전 개수 카운트

        for (int i = N - 1; i >= 0; i--) { // N 만큼, 큰 동전부터 비교 -> Greedy
            if (A[i] <= K) { // 비용보다 작거나 같으면
                cnt = cnt + K / A[i]; // 나눈 몫으로 개수를 세고
                K = K % A[i]; // 나눈 나머지로 비용을 초기화
            }
        }

        System.out.println(cnt); // 출력
    }
}
