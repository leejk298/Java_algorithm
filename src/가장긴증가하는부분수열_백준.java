import java.util.*;

/*
6
10 20 10 30 20 50
 */

public class 가장긴증가하는부분수열_백준 {
    static int N;   // 크기
    static int[] arr, dp;   // 입력, dp 배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N];
        dp = new int[N];

        for(int i = 0; i < N; i++) {    // 크기만큼
            arr[i] = sc.nextInt();  // 입력배열 저장
            dp[i] = 1;  // dp 배열 초기화
        }
    }

    public static void printLIS() { // 가장 긴 증가 수열 길이 출력

        int max = 1;    // 최대값
        for(int i = 0; i < N; i++) {    // 크기만큼
            for(int j = 0; j < i; j++) {    // 이전값과 비교하여
                if(arr[i] > arr[j]) // 크면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 해당 증가 길이 저장
            }

            max = Math.max(max, dp[i]); // 최대 증가 길이
        }

        System.out.println(max);    // 최대값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printLIS(); // 가장 긴 증가 수열 길이 출력
    }
}
