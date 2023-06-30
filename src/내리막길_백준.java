import java.util.*;
import java.io.*;

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
 */

public class 내리막길_백준 {
    static int N, M;    // 크기
    static int[][] map, dp; // 입력, dp 배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {   // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < M; j++) {   // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
                dp[i][j] = -1;  // dp 배열 초기화
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지

        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int DFS(int x, int y) {   // DFS (백트래킹) + dp

        if (x == N - 1 && y == M - 1)   // 도달하면
            return 1;   // 1 리턴

        if (dp[x][y] == -1) {   // 방문한 적이 없으면

            dp[x][y] = 0;   // 방문

            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

                if (isNotValidPos(tmpX, tmpY))  // 유효한지
                    continue;

                if (map[tmpX][tmpY] < map[x][y])    // 작으면
                    dp[x][y] += DFS(tmpX, tmpY);    // 방문, 리턴되면 이전 좌표에 값 더해줌 (경로 개수)
            }
        }

        return dp[x][y];    // (0, 0) => 총 경로 수
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(DFS(0, 0));  // DFS
    }
}
