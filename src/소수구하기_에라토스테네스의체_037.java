import java.util.Scanner;

public class 소수구하기_에라토스테네스의체_037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력

        int M = sc.nextInt(); // 시작
        int N = sc.nextInt(); // 끝
        int A[] = new int[N + 1]; // 배열 크기 => 인덱스 값 맞추기위해

        for (int i = 2; i <= N; i++) // N 까지
            A[i] = i; // 인덱스 값으로 설정

        for (int i = 2; i <= Math.sqrt(N); i++) { // N의 제곱근까지
            // => N보다 작은수는 N의 제곱근보다 작은 약수를 갖게되므로 N의 제곱근까지만 탐색
            if (A[i] == 0) // 소수가 아니면 통과 => 성능이 나쁘지않음
                continue;

            // 소수면
            for (int j = i + i; j <= N; j = j + i) // 소수의 배수는 전부
                A[j] = 0; // 소수가 아닌 수로 고침
        }

        for (int i = M; i <= N; i++) // M 부터 N 까지
            if (A[i] != 0) // 소수가 아닌 수
                System.out.println(A[i]); // 출력
    }
}
