import java.util.*;

/*
3
26 40 83
49 60 57
13 89 99
 */

public class RGB거리_백준 {
    static int N;   // 크기
    static int[][] dp;  // dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        dp = new int[N + 1][3]; // 초기화

        for(int i = 1; i <= N; i++) {   // 크기만큼
            int r = sc.nextInt();   // r
            int g = sc.nextInt();   // g
            int b = sc.nextInt();   // b

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;    // 1번 방
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;    // 2
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;    // 3
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));   // 최소비용 출력
    }
}
