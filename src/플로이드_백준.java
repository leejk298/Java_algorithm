import java.util.*;
import java.io.*;

/*
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
 */

public class 플로이드_백준 {
    static int N, M, INF;   // 크기, 최대값
    static int[][] dp;  // dp 배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링
        M = Integer.parseInt(st.nextToken());   // 엣지 개수
        INF = 100000 * (N - 1) + 1; // 최대값

        dp = new int[N + 1][N + 1]; // 초기화

        for(int i = 1; i <= N; i++) {   // 행
            for(int j = 1; j <= N; j++) {   // 열
                if(i == j)  // 같으면
                    dp[i][j] = 0;   // 0
                else    // 다르면
                    dp[i][j] = INF; // 최대값
            }
        }

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            if(dp[S][E] > W)    // 작은 값으로
                dp[S][E] = W;   // 갱신
        }
    }

    public static void FloydWarshall() {    // 플로이드워셜

        // N이 최대 100이므로 가능
        for(int k = 1; k <= N; k++) // 경유지 k에 대해
            for(int i = 1; i <= N; i++) // 시작점에서
                for(int j = 1; j <= N; j++) // 도착점까지
                    if(dp[i][j] > dp[i][k] + dp[k][j])  // 도달가능한 최소값이면
                        dp[i][j] = dp[i][k] + dp[k][j]; // 갱신

        StringBuilder sb = new StringBuilder(); // 결과 문자열

        for(int i = 1; i <= N; i++) {   // 행
            for(int j = 1; j <= N; j++) {   // 열
                if(dp[i][j] == INF) // 최대값 그대로 => 도달 x
                    sb.append(0 + " "); // 0
                else    // 도달 가능하면
                    sb.append(dp[i][j] + " ");  // 값 출력
            }

            sb.append("\n");    // 개행문자 출력
        }

        System.out.println(sb); // 결과 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        FloydWarshall();    // 플로이드워셜
    }
}
