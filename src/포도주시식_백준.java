import java.util.*;

/*
6
6
10
13
9
8
1
 */

public class 포도주시식_백준 {
    static int N;   // 크기
    static int[] arr, dp;  // 입력, dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N + 1];
        dp = new int[N + 1];

        for(int i = 1; i <= N; i++)
            arr[i] = sc.nextInt();  // 입력배열 저장
    }

    public static void printMaxWine() { // 포도주 최대 양 출력

        // 초기화
        dp[1] = arr[1];
        if(N > 1)
            dp[2] = arr[1] + arr[2];

        for(int i = 3; i <= N; i++) {   // 크기까지
            int one = dp[i - 2] + arr[i];   // -1 포도주 스킵
            int two = dp[i - 3] + arr[i - 1] + arr[i];  // -2 포도주 스킵

            dp[i] = Math.max(dp[i - 1], Math.max(one, two));    // 최대값
        }

        System.out.println(dp[N]);  // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMaxWine(); // 최대로 마실 수 있는 포도주 양 출력
    }
}
