import java.util.*;

/*
3 4
1 2 1
3 2 1
1 3 5
2 3 2
 */

public class 운동_백준 {
    static int N, M, INF;   // 크기, 최대값
    static int[][] dp;      // 동적배열

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 정점
        M = sc.nextInt();   // 노드
        INF = 400 * 10000 + 1;  // 최대값, 정점 400개, 엣지 가중치 10000

        // 초기화
        dp = new int[N + 1][N + 1];
        for(int i = 1; i <= N; i++)
            Arrays.fill(dp[i], INF);    // 무한대로

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝
            int w = sc.nextInt();   // 가중치

            dp[s][e] = w;   // 동적배열 저장
        }
    }

    public static void FloydWarshall() {    // 플로이드워셜

        for(int k = 1; k <= N; k++) // 경우지 K에 대해
            for(int i = 1; i <= N; i++) // 출발지점부터
                for(int j = 1; j <= N; j++) // 도착지점까지
                    if(dp[i][j] > dp[i][k] + dp[k][j])  // 도달가능하고 작으면
                        dp[i][j] = dp[i][k] + dp[k][j]; // 최단경로 갱신
    }

    public static void printIsCycle() { // 사이클인지, 최단경로

        int cycle = INF;    // 최대값
        for(int i = 1; i <= N; i++) // 정점 개수만큼
            cycle = Math.min(cycle, dp[i][i]);  // 시작 -> 도착이 같으면 사이클이므로

        if(cycle == INF)    // 없으면, 사이클이 아님
            System.out.println(-1); // -1
        else    // 사이클이 있으면
            System.out.println(cycle);  // 최소값 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        FloydWarshall();    // 플로이드워셜

        printIsCycle();     // 사이클, 최단경로 출력
    }
}