import java.util.*;
import java.io.*;

/*
3
 */

public class 이친수_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 크기

        long[] dp = new long[N + 1];    // dp 배열 초기화

        dp[0] = 0;  // 0일 때는 x
        dp[1] = 1;  // 1일 때는 1, 한 개
        for(int i = 2; i <= N; i++)   // 2부터 N까지
            dp[i] = dp[i - 1] + dp[i - 2];  // dp 계산

        System.out.println(dp[N]);  // N번째 값 출력
    }
}
