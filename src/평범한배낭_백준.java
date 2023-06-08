import java.util.*;

/*
4 7
6 13
4 8
3 6
5 12
 */

public class 평범한배낭_백준 {
    static int N, K;    // 크기
    static int[][] item, dp;    // 입력, dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 개수
        K = sc.nextInt();   // 무게

        // 초기화
        item = new int[N + 1][2];
        dp = new int[N + 1][K + 1];

        for(int i = 1; i <= N; i++) {   // 개수만큼
            item[i][0] = sc.nextInt();  // 무게
            item[i][1] = sc.nextInt();  // 가치
        }
    }

    public static void printMaxValue() {    // 최대 가치 출력

        for (int k = 1; k <= K; k++) { // 무게
            for (int i = 1; i <= N; i++) { // item
                dp[i][k] = dp[i - 1][k];    // dp 배열 초기화

                if (k - item[i][0] >= 0) // 담을 수 있으면
                    dp[i][k] = Math.max(dp[i - 1][k], item[i][1] + dp[i - 1][k - item[i][0]]);  // 최대 가치값 갱신
            }
        }

        System.out.println(dp[N][K]);   // 최대 가치 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMaxValue();    // 최대 가치 출력
    }
}
