import java.util.*;

/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
 */

public class 유기농배추_백준 {
    static int N, M, K, T;  // 크기
    static int[][] map; // 맵
    static boolean[][] visited; // 방문 배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    private static void init(Scanner sc) {  // 초기화
        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열
        K = sc.nextInt();   // 개수

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int j = 0; j < K; j++) {   // 개수만큼
            int x = sc.nextInt();   // 행
            int y = sc.nextInt();   // 열

            map[x][y] = 1;  // 1 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신

        while (!queue.isEmpty()) {  // 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                    continue;

                if (map[tmpX][tmpY] == 1) { // 1이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                }
            }
        }
    }

    public static void findCount() {    // 개수 찾기

        int count = 0;  // 개수
        for (int i = 0; i < N; i++) {   // 행
            for (int j = 0; j < M; j++) {   // 열
                if (map[i][j] == 1 && !visited[i][j]) { // 1이고 방문한 적이 없ㅇ므ㅕㄴ
                    BFS(i, j);  // BFS
                    count++;    // 개수 카운트
                }
            }
        }

        System.out.println(count);  // 개수 출력
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    // 입력

        T = sc.nextInt();   // 테스트 개수

        for (int i = 0; i < T; i++) {   // 개수만큼

            init(sc);   // 초기화

            findCount();    // 개수 찾기
        }
    }
}
