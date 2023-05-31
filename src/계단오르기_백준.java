import java.util.*;

/*
6
10
20
15
25
10
20
 */

public class 계단오르기_백준 {
    static int N;   // 크기
    static int[] stair; // 계단
    static int[] dp;    // dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        stair = new int[N + 2];
        dp = new int[N + 2];

        for(int i = 1; i <= N; i++) // 크기만큼
            stair[i] = sc.nextInt();    // 계단 저장
    }

    public static void printMaxPoint() {    // 최고 점수 출력

        dp[1] = stair[1];   // 처음은 같고
        dp[2] = Math.max(stair[1] + stair[2], stair[2]);    // 무조건 첫 번째 계단을 밟게끔

        for(int i = 3; i <= N; i++) // 3부터 크기까지
            dp[i] = Math.max(dp[i - 2] + stair[i], dp[i - 3] + stair[i - 1] + stair[i]);    // 최대값

        System.out.println(dp[N]);  // 최대값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMaxPoint();    // 최고 점수 출력
    }
}
