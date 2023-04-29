import java.io.*;
import java.util.*;
/*
4 6
101111
101010
101011
111011
 */

public class 미로탈출_백준 {
    static int N, M;    // 크기
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        visited = new boolean[N][M];
        map = new int[N][M];
        for(int i = 0; i < N; i++) {    // 행
            char[] ch = bf.readLine().toCharArray();    // 한 줄 스트링

            for(int j = 0; j < M; j++) {    // 열
                map[i][j] = ch[j] - '0';    // 저장
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS() {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {0, 0});  // 시작점 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now[] = queue.poll();   // 하나 꺼내어
            int nowX = now[0], nowY = now[1];   // 좌표

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 1이면
                    map[tmpX][tmpY] = map[nowX][nowY] + 1;  // 거리 계산
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS();  // BFS

        System.out.print(map[N - 1][M - 1]);    // 최단경로 출력
    }
}
