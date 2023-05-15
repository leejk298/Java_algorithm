import java.util.*;

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
    static int N, M, INF;   // 크기
    static int[][] map;     // 맵

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지
        INF = 100000 * (N - 1) + 1; // 최대값

        map = new int[N + 1][N + 1];    // 초기화

        for(int i = 1; i <= N; i++) {   // 행
            for(int j = 1; j <= N; j++) {   // 열
                if(i == j)  // 같으면
                    map[i][j] = 0;  // 0
                else    // 다르면
                    map[i][j] = INF;    // 최대값
            }
        }

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝
            int w = sc.nextInt();   // 가중치

            if (map[s][e] > w)  // 작은값으로
                map[s][e] = w;  // 갱신
        }
    }

    public static void FloydWarshall() {    // 플로이드워셜
        // N이 최대 100이므로 가능

        for(int k = 1; k <= N; k++) // 경유지에 대해
            for(int i = 1; i <= N; i++) // 시작점에서
                for(int j = 1; j <= N; j++) // 도착점까지
                    if(map[i][j] > map[i][k] + map[k][j])   // 도달가능하고 최소값이면
                        map[i][j] = map[i][k] + map[k][j];  // 갱신
    }

    public static void printShortestPath() {    // 최단경로 출력

        for(int i = 1; i <= N; i++) {   // 행
            for(int j = 1; j <= N; j++) {   // 열
                if(map[i][j] == INF)    // 초기값 그대로이면
                    System.out.print(0 + " ");  // 도달 X
                else    // 갱신되었으면 도달하였으므로
                    System.out.print(map[i][j] + " ");  // 출력
            }

            System.out.println();   // 개행문자 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        FloydWarshall();    // 플로이드워셜

        printShortestPath();    // 최단경로 출력
    }
}
