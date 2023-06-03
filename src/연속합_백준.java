import java.util.*;

/*
10
10 -4 3 1 5 6 -35 12 21 -1
 */

public class 연속합_백준 {
    static int N, max;  // 크기, 최대값
    static int[] arr, dp;   // 입력, dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        dp = new int[N];

        for(int i = 0; i < N; i++)  // 크기만큼
            arr[i] = sc.nextInt();  // 입력배열 저장
    }

    public static void printMax() { // 최대값 출력

        // 초기화
        dp[0] = arr[0];
        max = arr[0];

        for(int i = 1; i < N; i++) {    // 크기만큼
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);   // dp 배열 저장
            max = Math.max(max, dp[i]); // 최대값 저장
        }

        System.out.println(max);    // 최대값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMax(); // 최대값 출력
    }
}
