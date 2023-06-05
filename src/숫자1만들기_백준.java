import java.util.*;

/*
10
 */

public class 숫자1만들기_백준 {
    static int N;   // 크기
    static int[] dp;    // dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        dp = new int[N + 1];    // 초기화
    }

    public static void printMinCount() {    // 최소 연산 수 출력

        dp[1] = 0;  // 초기화
        for (int i = 2; i <= N; i++) {  // 크기까지
            dp[i] = dp[i - 1] + 1;  // 1 빼기

            if (i % 2 == 0) // 2 나누기
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // 원래 값과 2로 나눈값 + 1과 비교하여 작은 값

            if (i % 3 == 0) // 3 나누기
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        System.out.println(dp[N]);  // 값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMinCount();    // 최소 연산 수 출력
    }
}
