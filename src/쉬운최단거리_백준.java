import java.util.*;
import java.io.*;

/*
15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
 */

public class 쉬운최단거리_백준 {
    static int N, M, sX, sY;    // 크기, 좌표
    static int[][] map, D;  // 입력배열, 거리배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};  // 4방향
    static int[] dy = {0, 0, -1, 1};
    static StringBuilder sb;    // 결과 문자열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new int[N][M];
        D = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {    // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < M; j++) {    // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장

                if(map[i][j] == 2) {    // 시작 좌표
                    sX = i;
                    sY = j;
                }
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 큐에 삽입
        visited[x][y] = true;   // 방문여부 갱신
        D[x][y] = 0;    // 거리 0부터 시작

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효하지 않으면
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 땅이면
                    visited[tmpX][tmpY] = true; // 방문
                    D[tmpX][tmpY] = D[nowX][nowY] + 1;  // 거리 증가
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void printMap() { // 맵 출력

        sb = new StringBuilder();   // 결과 문자열

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 1 && !visited[i][j])    // 갈 수 있지만 방문할 수 없는 땅이면
                    sb.append(-1 + " ");    // -1

                else    // 아니면: 갈 수 있는 땅 or 갈 수 없는 땅
                    sb.append(D[i][j] + " ");   // 해당 거리값 출력
            }

            sb.append("\n");    // 개행문자
        }

        System.out.print(sb);   // 결과 문자열 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS(sX, sY);    // BFS

        printMap(); // 맵 출력
    }
}
