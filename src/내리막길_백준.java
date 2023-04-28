import java.util.*;

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
 */

public class 내리막길_백준 {
    static int N, M;    // 크기
    static int[][] map; // 맵
    static int[][] dp;  // dp 배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열

        // 초기화
        map = new int[N][M];
        dp = new int[N][M];
        for(int i = 0; i < N; i++) {    // 행
            for (int j = 0; j < M; j++) {   // 열
                map[i][j] = sc.nextInt();   // 저장
                dp[i][j] = -1;  // 초기화
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int DFS(int x, int y) {   // DFS

        if(x == N - 1 && y == M - 1)    // 도착하면
            return 1;   // 1을 리턴해서 다시 왔던 경로에 더해줌

        if(dp[x][y] == -1) {    // 방문한 적이 없으면
            dp[x][y] = 0;   // 방문여부 갱신

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(map[tmpX][tmpY] < map[x][y]) // 작으면
                    dp[x][y] += DFS(tmpX, tmpY);    // DFS 호출, 리턴하면 이전 경로에 값을 더해줌
            }
        }

        return dp[x][y];    // 해당 좌표값 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.print(DFS(0, 0));    // DFS
    }
}
