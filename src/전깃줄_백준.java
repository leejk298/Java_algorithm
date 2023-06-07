import java.util.*;

/*
8
1 8
3 9
2 2
4 1
6 4
10 10
9 7
7 6
 */

public class 전깃줄_백준 {
    static int N;   // 크기
    static int[] dp;    // dp
    static int[][] arr; // 입력배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        arr = new int[N][2];
        dp = new int[N];

        for (int i = 0; i < N; i++) {   // 크기만큼
            arr[i][0] = sc.nextInt();   // 입력
            arr[i][1] = sc.nextInt();
            dp[i] = 1;  // dp 초기화
        }

        Arrays.sort(arr, ((o1, o2) -> o1[0] - o2[0]));  //  왼쪽 전봇대 기준으로 오름차순 정렬
    }

    public static void printMinCount() {    // 최소 전깃줄 개수 출력

        int max = 1;    // 최대값
        for (int i = 0; i < N; i++) {   // 크기만큼
            for (int j = 0; j < i; j++) {   // 이전 값과 비교하여
                if (arr[i][1] > arr[j][1])  // 크면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 해당 증가 길이 저장
            }

            max = Math.max(max, dp[i]); // 최대 증가 길이
        }

        System.out.println(N - max);    // 크기에서 최대값 뺌, 최소값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMinCount();    // 최소 전깃줄 개수 출력
    }
}
