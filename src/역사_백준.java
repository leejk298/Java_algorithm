import java.io.*;
import java.util.*;

/*
5 5
1 2
1 3
2 3
3 4
2 4
3
1 5
2 4
3 1
 */

public class 역사_백준 {
    static int N, M, K; // 크기
    static int[][] dp;  // dp 배열

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        dp = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 끝

            dp[S][E] = -1;  // 앞 순서 -1
            dp[E][S] = 1;   // 뒤 순서 1
        }

        for(int k = 1; k <= N; k++) // 경유지에 대해
            for(int i = 1; i <= N; i++) // 시작점부터
                for(int j = 1; j <= N; j++) // 도착점까지
                    if(dp[i][k] == -1 && dp[k][j] == -1) {  // 도달 가능하면
                        dp[i][j] = -1;  // -1
                        dp[j][i] = 1;   // 반대 경우는 1
                    }

        K = Integer.parseInt(bf.readLine());    // 테스트케이스 개수

        for(int i = 0; i < K; i++) {    // 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착

            System.out.println(dp[S][E]);   // 값 출력
        }
    }
}
