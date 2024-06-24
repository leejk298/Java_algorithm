import java.io.*;
import java.util.*;

/*
3 4 5
3 2
2 2
3 1
2 3
1 1
 */

public class 음식물피하기_백준 {
    static int N, M, K; // 크기
    static int[][] map; // 입력배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        K = Integer.parseInt(st.nextToken());   // 좌표 개수

        map = new int[N][M];    // 입력배열
        visited = new boolean[N][M];    // 방문배열

        for (int i = 0; i < K; i++) {   // 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int x = Integer.parseInt(st.nextToken());   // 좌표 x
            int y = Integer.parseInt(st.nextToken());   // y

            map[x - 1][y - 1] = 1;  // 해당 좌표에 1 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int BFS(int x, int y) {   // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 큐에 시작점 삽입
        visited[x][y] = true;   // 시작점 방문
        int count = 1;  // 개수 카운트

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표

            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                    continue;

                if (map[tmpX][tmpY] == 1) { // 1이면
                    visited[tmpX][tmpY] = true; // 방문
                    count++;    // 개수 카운트
                    queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                }
            }
        }

        return count;   // 총 개수 리턴
    }

    public static void findMaxCount() { // 최대값 찾기

        int max = 0;    // 최대값

        for (int i = 0; i < N; i++) // 행
            for (int j = 0; j < M; j++) // 열
                if (map[i][j] == 1 && !visited[i][j])   // 1이고 방문한 적이 없으면
                    max = Math.max(max, BFS(i, j)); // BFS, 최대값 저장

        System.out.println(max);    // 최대값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findMaxCount(); // 최대값 찾기
    }
}
