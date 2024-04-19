import java.util.*;
import java.io.*;

/*
7
3
7
5
2
6
1
4
 */

public class 줄세우기2_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        int N = Integer.parseInt(st.nextToken());   // 크기

        int[] arr = new int[N]; // 입력배열
        for (int i = 0; i < N; i++) {   // 크기만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 저장
        }

        int[] dp = new int[N];  // dp 배열

        dp[0] = 1;  // 초기화
        int res = 0;

        for (int i = 1; i < N; i++) {   // 1부터 크기만큼
            dp[i] = 1;  //  초기화

            for (int j = 0; j < i; j++) // 0 ~ i
                if (arr[i] > arr[j])    // i 값이 더 크면
                    dp[i] = Math.max(dp[i], dp[j] + 1); // dp값 갱신

            res = Math.max(res, dp[i]); // 결과값 갱신
        }

        System.out.println(N - res);    // N - 최대길이 => 가장 적은 수의 아이를 옮기는 횟수
    }
}
