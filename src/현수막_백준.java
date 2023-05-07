import java.util.*;

/*
8 19
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 1 0 0 0 1 0 0 0 1 0 1 1 1 1 1 0
0 0 1 0 1 0 0 1 1 0 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 1 1 1 1 0 1 0 1 0 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 1 1 0 0 0 1 0 0 0
0 1 0 0 0 1 0 1 0 0 0 1 0 0 0 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
 */

public class 현수막_백준 {
    static int N, M;    // 크기
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};  // 8방향
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열

        // 초기화
        map =  new int[N][M];
        visited = new boolean[N][M];

        // 맵 저장
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 8; i++) {    // 8방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 1 이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static int findLetterCount() {   // 글자수 세기
        int count = 0;  // 개수

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 1 && !visited[i][j]) {  // 1 이면서 방문하지 않았으면
                    BFS(i, j);  // BFS
                    count++;    // 개수 카운트
                }
            }
        }

        return count;   // 개수 리턴
    }

    public static void main(String[] args) {

        init(); // 초기화

        System.out.println(findLetterCount());  // 개수 출력
    }
}
