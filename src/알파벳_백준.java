import java.util.*;
import java.io.*;

/*
3 6
HFDFFB
AJHGDH
DGAGEH
 */

public class 알파벳_백준 {
    static int N, M, max;   // 크기, 결과값
    static int[][] map; // 입력배열
    static boolean[] visited;   // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        max = 0;    // 결과값

        map = new int[N][M];    // 입력배열
        visited = new boolean[26];  // 방문배열, 알파벳 개수

        for (int i = 0; i < N; i++) {   // 행
            String str = bf.readLine(); // 한 줄 스트링

            for (int j = 0; j < M; j++) // 열
                map[i][j] = str.charAt(j) - 'A';    // 정수형 배열로 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void DFS(int x, int y, int count) {   // DFS, 백트래킹

        visited[map[x][y]] = true;   // 방문
        max = Math.max(max, count);  // 최대값 갱신

        for (int i = 0; i < 4; i++) { // 4방향
            int tmpX = x + dx[i], tmpY = y + dy[i];  // 다음좌표

            if (isNotValidPos(tmpX, tmpY))    // 유효한지
                continue;

            if (!visited[map[tmpX][tmpY]]) {  // 방문한 적이 없으면
                DFS(tmpX, tmpY, count + 1);  // DFS, 재귀콜
                visited[map[tmpX][tmpY]] = false;    // 리턴되면 방문여부 갱신
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0, 0, 1);   // DFS, 백트래킹

        System.out.println(max);    // 최대값 출력
    }
}
