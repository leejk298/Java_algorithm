import java.util.*;

/*
2
6
12
 */

public class 파도반수열_백준 {
    static int T;   // 테스트케이스 개수
    static int[] arr;   // 인덱스배열
    static long[] dp;   // dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        T = sc.nextInt();   // 테스트케이스

        // 초기화
        dp = new long[101];
        arr = new int[T];

        for(int i = 0; i < T; i++)  // 개수만큼
            arr[i] = sc.nextInt();  // 인덱스

        // dp 배열 초기화
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
    }

    public static void printNum() { // 수열 출력

        for(int i = 0; i < T; i++) {    // 개수만큼
            int index = arr[i]; // 인덱스

            for(int j = 4; j <= index; j++) // 4부터 인덱스까지
                dp[j] = dp[j - 2] + dp[j - 3];  // 점화식

            System.out.println(dp[index]);  // 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        printNum(); // 숫자 출력
    }
}
