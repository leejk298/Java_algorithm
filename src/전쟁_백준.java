import java.util.*;
import java.io.*;

/*
5 5
WBWWW
WWWWW
BBBBB
BBBWW
WWWWW
 */

public class 전쟁_백준 {
    static int N, M;    // 크기
    static int wCount, bCount;  // 개수
    static char[][] map;    // 입력배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 열
        N = Integer.parseInt(st.nextToken());   // 행

        wCount = 0; // 개수 초기화
        bCount = 0;

        map = new char[N][M];   // 입력배열
        visited = new boolean[N][M];    // 방문배열

        for (int i = 0; i < N; i++) // 행
            map[i] = bf.readLine().toCharArray();   // 입력배열 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y, char ch) { // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 시작점 큐에 삽입
        visited[x][y] = true;   // 방문

        if (ch == 'W')  // W이면
            wCount++;   // 개수 카운트
        else    // B이면
            bCount++;   // 개수 카운트

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재좌표

            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                    continue;

                if (map[tmpX][tmpY] == ch) {    // 현재 문자와 같으면
                    visited[tmpX][tmpY] = true; // 방문
                    queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입

                    if (ch == 'W')  // W이면
                        wCount++;   // 개수 카운트
                    else    // B이면
                        bCount++;   // 개수 카운트
                }
            }
        }
    }

    public static void printCount() {   // 개수 출력

        int wSum = 0, bSum = 0; // 총합

        for (int i = 0; i < N; i++) {   // 행
            for (int j = 0; j < M; j++) {   // 열
                if (!visited[i][j]) {   // 방문한 적이 없으면
                    BFS(i, j, map[i][j]);   // BFS

                    if (map[i][j] == 'W')   // W이면
                        wSum += Math.pow(wCount, 2);    // W 개수의 제곱을 더함
                    else    // B이면
                        bSum += Math.pow(bCount, 2);    // B 개수의 제곱을 더함

                    wCount = 0; // 개수 초기화
                    bCount = 0;
                }
            }
        }

        System.out.println(wSum + " " + bSum);  // 총합 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printCount();   // 개수 출력
    }
}
