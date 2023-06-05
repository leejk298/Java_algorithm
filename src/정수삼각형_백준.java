import java.util.*;

/*
5
7
3 8
8 1 0
2 7 4 4
4 5 2 6 5
 */

public class 정수삼각형_백준 {
    static int N;   // 크기
    static int[][] dp; // dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        dp = new int[N][];  // 초기화

        for (int i = 0; i < N; i++) {   // 행
            dp[i] = new int[i + 1]; // 삼각형처럼 선언

            for (int j = 0; j < i + 1; j++) {   // 크기만큼
                dp[i][j] = sc.nextInt();    // 저장
            }
        }
    }

    public static void printMaxSumPath() {  // 최대비용 경로 출력

        for (int i = N - 1; i > 0; i--) // 밑에서부터
            for (int j = 0; j < i; j++) // 열
                dp[i - 1][j] += Math.max(dp[i][j], dp[i][j + 1]);   // 위로 올라가면서 값 갱신

        System.out.println(dp[0][0]);   // 최대값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMaxSumPath();  // 최대값 출력
    }
}
