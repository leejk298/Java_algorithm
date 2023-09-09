import java.util.*;

/*
3 3
255 255 255 100 100 100 255 255 255
100 100 100 255 255 255 100 100 100
255 255 255 100 100 100 255 255 255
101
 */

public class 영상처리_백준 {
    static int N, M, T;  // 개수
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) // 행
            for (int j = 0; j < M * 3; j++) // 열
                map[i][j / 3] += sc.nextInt();  // 3개씩 저장

        T = sc.nextInt();   // 경계값

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] / 3 < T)  // 작으면 0
                    map[i][j] = 0;
                else    // 크거나 같으면 255
                    map[i][j] = 255;
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                    continue;

                if (map[tmpX][tmpY] == 255) {   // 255이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                }
            }
        }
    }

    public static int findPixel() {    // 픽셀 개수 찾기

        int count = 0;  // 개수

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 255 && !visited[i][j]) {   // 255이면서 방문하지 않았으면
                    BFS(i, j);  // BFS
                    count++;    // 개수 카운트
                }
            }
        }

        return count;   // 총 개수 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.println(findPixel());    // 총 픽셀수 출력
    }
}
