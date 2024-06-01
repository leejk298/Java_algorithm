import java.io.*;
import java.util.*;

public class 경로찾기_플로이드워셜_062 {
    static int N;   // 크기
    static int[][] dp;  // dp 배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 노드 개수
        dp = new int[N + 1][N + 1]; // 인접행렬

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            for (int j = 1; j <= N; j++) // 2차 배열
                dp[i][j] = Integer.parseInt(st.nextToken()); // 인접행렬 구현
        }
    }

    public static void FloydWarshall() {  // 플로이드워셜 알고리즘

        for (int k = 1; k <= N; k++) // 경유지 K에 대해
            for (int i = 1; i <= N; i++) // 출발노드 S
                for (int j = 1; j <= N; j++) // 도착노드 E
                    if (dp[i][k] == 1 && dp[k][j] == 1) // 경유지 K를 거치는 길이 있으면
                        dp[i][j] = 1; // 출발 -> 도착으로 가는 길이 있다 (가중치 X)

        for (int i = 1; i <= N; i++) { // 행
            for (int j = 1; j <= N; j++)    // 열
                System.out.print(dp[i][j] + " ");   // 결과값 출력
            System.out.println(); // 개행문자 출력
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        FloydWarshall();    // 플로이드워셜
    }
}
