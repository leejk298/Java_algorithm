import java.util.*;

/*
5
 */

public class 피보나치수1_백준 {
    static int res1, res2;  // 출력
    static int[] dp;    // dp 배열

    public static int fib(int N) {  // fib, 재귀

        if(N == 1 || N == 2) {  // 베이스케이스
            res1++;

            return 1;
        }

        // 재귀케이스
        return fib(N - 1) + fib(N - 2);
    }

    public static int fibonacci(int N) {    // fibonacci, dp

        dp[0] = dp[1] = 1;  // 초기화

        for(int i = 2; i < N; i++) {    // 2부터 N까지
            res2++;
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[N - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int N = sc.nextInt();   // 크기

        dp = new int[N + 1];    // 초기화

        fib(N); // fib

        fibonacci(N);   // fibonacci

        System.out.println(res1 + " " + res2);  // 결과값 출력
    }
}
