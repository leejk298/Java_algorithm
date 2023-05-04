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
    static int N, M, K, count;  // 크기, 개수
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열
        K = sc.nextInt();   // 개수

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < K; i++) {    // 개수만큼
            int x = sc.nextInt();   // 좌표
            int y = sc.nextInt();

            map[x - 1][y - 1] = 1;  // 맵 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신
        count++;    // 개수 카운트

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 1이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    count++;    // 개수 카운트
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static int findMaxCount() {  // 최대 개수 찾기
        int max = 0;    // 최대값

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 1 && !visited[i][j]) {  // 1이고 방문하지 않았으면
                    count = 0;  // 초기화
                    BFS(i, j);  // BFS

                    if(max < count) // 최대값 찾기
                        max = count;
                }
            }
        }

        return max; // 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.println(findMaxCount()); // 최대값 출력
    }
}
