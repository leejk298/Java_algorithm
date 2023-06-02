import java.util.*;

/*
4
 */

public class 타일01_백준 {
    static int N, mod;  // 크기
    static int[] dp;    // dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        mod = 15746;

        dp = new int[N + 1];    // 초기화
    }

    public static void printCount() {   // 개수 출력

        // 초기화
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= N; i++) // 3부터 N까지
            dp[i] = (dp[i - 1] + dp[i - 2]) % mod;  // dp 배열 저장

        System.out.println(dp[N]);  // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        if(N == 1)  // 1이면 그대로 1 출력 => 함수에서 dp[2]를 초기화 시키므로 ArrayIndexOutOfBounds
            System.out.println(1);
        else
            printCount();   // 개수 출력
    }
}
