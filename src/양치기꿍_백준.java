import java.util.*;
import java.io.*;

/*
8 8
.######.
#..k...#
#.####.#
#.#v.#.#
#.#.k#k#
#k.##..#
#.v..v.#
.######.
 */

public class 양치기꿍_백준 {
    static int N, M, S, W;  // 크기
    static char[][] map;    // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new char[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++)  // 행
            map[i] = bf.readLine().toCharArray();   // 맵 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        S = 0;  // 양
        W = 0;  // 늑대
        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            if(map[nowX][nowY] == 'k')  // k 이면
                S++;    // 양 개수 카운트
            if(map[nowX][nowY] == 'v')  // v 이면
                W++;    // 늑대 개수 카운트

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] != '#') {    // # 이 아니면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void printSheepAndWolfCount() {   // 양과 늑대 개수 출력

        int sCount = 0, wCount = 0; // 개수

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] != '#' && !visited[i][j]) {    // # 이 아니면서 방문하지 않았으면
                    BFS(i, j);  // 해당 좌표로 BFS

                    if (S > W)  // 양이 더 많은경우
                        sCount += S;    // 양만 증가
                    else    // 아니면
                        wCount += W;    // 늑대만 증가
                }
            }
        }

        System.out.println(sCount + " " + wCount);  // 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printSheepAndWolfCount();   // 출력
    }
}
