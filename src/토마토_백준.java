import java.util.*;

/*
6 4
1 -1 0 0 0 0
0 -1 0 0 0 0
0 0 0 0 -1 0
0 0 0 0 -1 1
 */

public class 토마토_백준 {
    static int N, M;    // 크기
    static int[][] map; // 맵
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue;  // 큐

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        M = sc.nextInt();   // 열
        N = sc.nextInt();   // 행

        // 초기화
        map = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();   // 맵 저장

                if (map[i][j] == 1) // 1이면
                    queue.offer(new int[]{i, j});   // 큐에 삽입
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS() {  // BFS

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || map[tmpX][tmpY] == -1)  // 유효하지 않으면
                    continue;

                if(map[tmpX][tmpY] == 0) {  // 0 이면
                    map[tmpX][tmpY] = map[nowX][nowY] + 1;  // 거리 + 1
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static int checkTomato() {   // 토마토 며칠 걸리는지
        int answer = 0; // 일

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 0)  // 0 이면
                    return -1;  // -1 리턴
                else if(map[i][j] > answer) // 최대값
                    answer = map[i][j];
            }
        }

        return answer - 1;  // 1부터 시작이므로 -1 해주므로 1일 때 0 잡을 수 있음
    }

    public static void main(String[] args) {

        init(); // 초기화

        BFS();  // BFS

        System.out.println(checkTomato());  // 며칠 걸리는지 출력
    }
}
