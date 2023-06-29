import java.io.*;
import java.util.*;

public class 점프점프_백준 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        for(int i = 0; i < N; i++) {    // 크기만큼
            arr[i] = Integer.parseInt(st.nextToken());  // 입력배열 초기화
            dp[i] = Integer.MAX_VALUE;  // dp 배열 초기화
        }

        dp[0] = 0;  // 초기값 0, 0부터 시작
        for(int i = 0; i < N; i++) {    // 크기만큼
            if(dp[i] == Integer.MAX_VALUE)  // 메모이제이션, 갱신되어있지 않으면
                continue;   // 도달 불가이므로 건너뛰기

            for(int j = 0; j <= arr[i]; j++) {  // 몇 칸까지
                if (i + j >= N) // 칸 수가 총 크기를 넘어가면
                    break;  // for - j 탈출
                // 안넘어가는 동안
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);     // dp 갱신
            }
        }

        if(dp[N - 1] == Integer.MAX_VALUE)  // 오른쪽 끝까지 도달 불가이면
            System.out.println(-1); // -1 출력
        else    // 도달 가능이면
            System.out.println(dp[N - 1]);  // 값 출력
    }
}
