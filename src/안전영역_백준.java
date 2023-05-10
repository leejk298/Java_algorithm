import java.util.*;

/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */

public class 안전영역_백준 {
    static int N, max;  // 크기
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        map = new int[N][N];    // 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();   // 맵 저장

                if(max < map[i][j]) // 최대 높이 구하기
                    max = map[i][j];
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS(int x, int y, int h) {   // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 시작점 추가
        visited[x][y] = true;   // 방문여부 갱신

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                    continue;

                if (map[tmpX][tmpY] > h) {  // 안전한 곳
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                }
            }
        }
    }

    public static int countMaxArea() {  // 최대 안전지역 개수
        int maxCount = 0;   // 개수

        for (int h = 0; h <= max; h++) {    // 0부터 시작해야 1인 곳도 체크 가능
            int count = 0;
            visited = new boolean[N][N];    // 방문배열 초기화

            for (int i = 0; i < N; i++) {   // 행
                for (int j = 0; j < N; j++) {   // 열
                    if (map[i][j] > h && !visited[i][j]) {  // 안전하고 방문한 적이 없으면
                        BFS(i, j, h);   // BFS
                        count++;    // 개수
                    }

                    if(maxCount < count)    // 최대값 찾기
                        maxCount = count;
                }
            }
        }

        return maxCount;    // 최대값 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.println(countMaxArea()); // 최대 안전지역 출력
    }
}
