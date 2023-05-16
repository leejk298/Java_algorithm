import java.util.*;
import java.io.*;

/*
8 8
11000111
01100000
00011001
11001000
10001001
10111100
01010000
00001011
 */

public class 침투_백준 {
    static int N, M;    // 크기
    static boolean isCorrect;   // 침투가능한지
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        isCorrect = false;
        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            char[] ch = bf.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                map[i][j] = ch[j] - '0';    // 맵 저장
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void DFS(int x, int y) {  // DFS

        visited[x][y] = true;   // 방문여부 갱신

        if(x == N - 1) {    // 마지막 행 도착하면
            isCorrect = true;   // 침투가능

            return; // 함수 종료
        }

        for(int i = 0; i < 4; i++) {    // 4방향
            int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

            if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                continue;

            if(map[tmpX][tmpY] == 0)    // 0이면
                DFS(tmpX, tmpY);    // DFS
        }
    }

    public static void checkIsCorrect() {   // 침투가능한지 확인

        for(int i = 0; i < M; i++) {    // 열
            if(isCorrect)   // 가능하면
                break;  // 반복문 탈출, 함수 종료

            if (map[0][i] == 0) {   // 첫 행
                visited = new boolean[N][M];    // 방문배열 초기화
                DFS(0, i);  // DFS
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        checkIsCorrect();   // 침투가능한지

        if(isCorrect)   // 가능하면
            System.out.println("YES");  // YES
        else    // 아니면
            System.out.println("NO");   // NO 출력
    }
}
