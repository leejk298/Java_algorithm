import java.util.*;

/*
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
 */

public class 욕심쟁이판다_백준 {
    static int N;  // 크기
    static int[][] map; // 맵
    static int[][] dp;  // DP 배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        map = new int[N][N];
        dp = new int[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();   // 맵 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static int DFS(int x, int y) {   // DFS

        if(dp[x][y] != 0)   // 메모이제이션, 이미 정해진 경우 그대로
            return dp[x][y];

        dp[x][y] = 1;   // 0이면 1로, 자기 자신

        for(int i = 0; i < 4; i++) {    // 4방향
            int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

            if(isNotValidPos(tmpX, tmpY))   // 유효한지
                continue;

            if(map[x][y] < map[tmpX][tmpY]) // 갈 수 있는 경로이면
                dp[x][y] = Math.max(dp[x][y], DFS(tmpX, tmpY) + 1); // DP 배열, 다음 좌표 + 1 중 최대값
        }

        return dp[x][y];    // 해당 좌표의 dp 배열값 리턴
    }

    public static int printMaxShift() { // 최대값 출력

        int max = 0;    // 최대값
        for(int i = 0; i < N; i++)  // 행
            for(int j = 0; j < N; j++)  // 열
                max = Math.max(max, DFS(i, j)); // 최대값, DFS

        return max; // 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.println(printMaxShift());    // 최대값 출력
    }
}
