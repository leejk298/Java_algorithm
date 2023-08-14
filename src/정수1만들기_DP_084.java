import java.util.*;

public class 정수1만들기_DP_084 {
    static int N;
    static int[] dp;

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in); // 입력받기

        N = sc.nextInt(); // 숫자
        dp = new int[N + 1]; // 연산 결과배열
    }

    public static void findCount() {    // 개수 찾기

        dp[1] = 0; // 1 일때는 연산이 필요없으므로 0으로 초기화
        for (int i = 2; i <= N; i++) { // 연산배열
            dp[i] = dp[i - 1] + 1; // - 1 연산

            if (i % 2 == 0) // 2의 배수 연산
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 최소값으로 설정

            if (i % 3 == 0) // 3의 배수 연산
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // + 1 : 해당 연산횟수 포함하므로
        }

        System.out.println(dp[N]); // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        findCount();    // 개수 찾기
    }
}
