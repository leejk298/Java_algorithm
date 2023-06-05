import java.util.*;

/*
2
 */

public class 쉬운계단수_백준 {
    static int N;   // 크기
    static long[][] dp; // dp 배열
    static long mod;

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        mod = 1000000000;

        // 초기화
        dp = new long[N + 1][10];
        for(int i = 1; i <= 9; i++)
            dp[1][i] = 1;   // 처음
    }

    public static void printStairCount() {  // 계단 수 출력

        for(int i = 2; i <= N; i++) {   // 크기까지
            for(int j = 0; j <= 9; j++) {   // 높이
                if(j == 0)  // 왼쪽 끝
                    dp[i][j] = dp[i - 1][j + 1] % mod;

                else if(j == 9) // 오른쪽 끝
                    dp[i][j] = dp[i - 1][j - 1] % mod;

                else    // 중간
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
            }
        }

        long sum = 0;   // 총 합
        for(int i = 0; i <= 9; i++) // 높이
            sum += dp[N][i];    // 더해서

        System.out.println(sum % mod);  // 값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printStairCount();  // 계단 수 출력
    }
}
