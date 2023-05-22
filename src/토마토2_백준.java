import java.util.*;

/*
5 3 2
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 1 0 0
0 0 0 0 0
 */

public class 토마토2_백준 {
    static int N, M, H;    // 크기
    static int[][][] map;   // 맵
    static int[] dx = {-1, 1, 0, 0, 0, 0};  // 6방향
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue;  // 큐

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        M = sc.nextInt();   // 세로
        N = sc.nextInt();   // 가로
        H = sc.nextInt();   // 높이

        // 초기화
        map = new int[H][N][M];
        queue = new LinkedList<>();

        for(int i = 0; i < H; i++) {    // 높이
            for (int j = 0; j < N; j++) {   // 행
                for (int k = 0; k < M; k++) {   // 열
                    map[i][j][k] = sc.nextInt();    // 맵 저장

                    if(map[i][j][k] == 1)   // 익었으면
                        queue.offer(new int[] {i, j, k});   // 큐에 저장
                }
            }
        }
    }

    public static boolean isNotValidPos(int z, int x, int y) {  // 좌표가 유효한지
        return (z < 0 || z >= H || x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS() {  // BFS

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowH = now[0], nowX = now[1], nowY = now[2];    // 좌표
            for(int i = 0; i < 6; i++) {    // 6방향
                int tmpH = nowH + dz[i], tmpX = nowX + dx[i], tmpY = nowY + dy[i];  // 다음 좌표

                if(isNotValidPos(tmpH, tmpX, tmpY)) // 유효한지
                    continue;

                if(map[tmpH][tmpX][tmpY] == 0) {    // 안익었으면
                    map[tmpH][tmpX][tmpY] = map[nowH][nowX][nowY] + 1;  // 익히기
                    queue.offer(new int[] {tmpH, tmpX, tmpY});  // 큐에 삽입
                }
            }
        }
    }

    public static int printDay() {  // 걸린 일

        int day = -2;   // 일

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(map[i][j][k] == 0)   // 0이 있으면 안되므로 -1 출력
                        return -1;

                    day = Math.max(day, map[i][j][k]);  // 최대일
                }
            }
        }

        return day - 1; // 최대일 - 1, 1부터 시작했으므로
    }

    public static void main(String[] args) {

        init(); // 초기화

        BFS();  // BFS

        System.out.println(printDay()); // 걸린 일 수 출력
    }
}
