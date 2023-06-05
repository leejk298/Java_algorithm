import java.util.*;

/*
3
26 40 83
49 60 57
13 89 99
 */

public class RGB거리_백준 {
    static int N;
    static int[][] dp;

    public static void init() {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new int[N + 1][3];

        for(int i = 1; i <= N; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;
        }
    }

    public static void main(String[] args) {

        init();

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
