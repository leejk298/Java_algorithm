import java.util.*;

/*
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
 */

public class 치즈2_백준 {
    static int N, M, cheese;    // 크기
    static int[][] map;     // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1 , 1};

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();   // 맵 저장

                if(map[i][j] == 1)  // 1 이면
                    cheese++;   // 치즈 개수 카운트
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 유효한 좌표인지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS() {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {0, 0});  // 시작점 큐에 삽입
        visited[0][0] = true;   // 방문여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 1 이면
                    map[tmpX][tmpY] = 0;    // 0으로 갱신
                    cheese--;   // 치즈 개수 갱신
                } else {    // 0 이면
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }

                visited[tmpX][tmpY] = true; // 방문여부 갱신
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        int time = 0, count = 0;  // 시간, 개수
        while(cheese != 0) {    // 치즈가 다 녹지 않으면
            time++; // 시간 갱신
            count = cheese; // 개수 저장

            BFS();  // BFS

            visited = new boolean[N][M];    // 초기화
        }

        System.out.println(time);   // 시간
        System.out.println(count);  // 개수 출력
    }
}
