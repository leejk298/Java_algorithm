import java.util.*;
import java.io.*;

/*
4
14 9 12 10
1 11 5 4
7 15 2 13
6 3 16 8
 */

public class 욕심쟁이판다_백준 {
    static int N;  // 크기
    static int[][] map, dp; // 입력, dp 배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        map = new int[N][N];    // 초기화
        dp = new int[N][N];

        for(int i = 0; i < N; i++) {    // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < N; j++)  // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static int DFS(int x, int y) {   // DFS

        if(dp[x][y] != 0)   // 메모이제이션, 초기값이 아니면
            return dp[x][y];    // 그대로 값 리턴

        // 초기값 그대로이면
        dp[x][y] = 1;   // 1로 초기화, 자기자신

        for(int i = 0; i < 4; i++) {    // 4방향
            int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

            if(isNotValidPos(tmpX, tmpY))   // 유효한지
                continue;

            if(map[x][y] < map[tmpX][tmpY]) // 다음 좌표의 값이 더 크면
                dp[x][y] = Math.max(dp[x][y], DFS(tmpX, tmpY) + 1); // dp 배열 갱신, 자신과 다음 좌표값 + 1
        }

        return dp[x][y];    // dp값 리턴
    }

    public static int printMaxCount() { // 최대값 출력

        int max = 0;    // 최대값

        for(int i = 0; i < N; i++)  // 행
            for(int j = 0; j < N; j++)  // 열
                max = Math.max(max, DFS(i, j)); // 최대값 갱신, 브루트포스

        return max; // 최대값 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(printMaxCount());    // 최대값 출력
    }
}
