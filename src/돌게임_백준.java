import java.util.*;
import java.io.*;

/*
5
 */

public class 돌게임_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        int[] dp = new int[1001];   // dp 배열 초기화

        // 상근 승: 홀수 / 창영 승: 짝수
        dp[1] = 1;  // 상근 1개 => 상근 승
        dp[2] = 2;  // 상근 1개 -> 창영 1개 => 창영 승
        dp[3] = 1;  // 상근 1개 -> 창영 1개 -> 상근 1개 => 상근 승 / 상근 3개 => 상근 승

        for (int i = 4; i <= N; i++)    // 크기만큼
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1; // dp 배열 저장

        if (dp[N] % 2 == 1) // 홀수
            System.out.println("SK"); // 상근 승
        else    // 짝수
            System.out.println("CY");   // 창영 승
    }
}
