import java.io.*;
import java.util.*;

/*
1
4 4
0 0 0 0
1 0 0 0
0 0 1 0
0 1 0 0
 */

public class 말이되고픈원숭이_백준 {
    static int N, M, K; // 크기
    static int[][] map; // 입력배열
    static boolean[][][] visited;   // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 원숭이 4방향
    static int[] dy = {0, 0, -1, 1};
    static int[] dx2 = {-2, -2, -1, -1, 1, 1, 2, 2};    // 말 8방향
    static int[] dy2 = {-1, 1, 2, -2, 2, -2, -1, 1};

    static class Node { // 노드 클래스
        int x, y, z, d;

        public Node(int x, int y, int z, int d) {   // 파라미터 생성자
            this.x = x; // 좌표
            this.y = y;
            this.z = z; // 찬스
            this.d = d; // 거리
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        K = Integer.parseInt(st.nextToken());   // 찬스

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 열
        N = Integer.parseInt(st.nextToken());   // 행

        // 초기화
        map = new int[N][M];
        visited = new boolean[K + 1][N][M]; // 3차원

        for(int i = 0; i < N; i++) {    // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < M; j++)  // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 유효한 좌표인지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int BFS(int x, int y, int k, int d) { // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(x, y, k, d));  // 시작점 큐에 삽입
        visited[k][x][y] = true;    // 시작점 방문
        
        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어
            
            int nowX = now.x, nowY = now.y, nowZ = now.z, nowD = now.d; // 현재 좌표, 찬스, 거리

            if(nowX == N - 1 && nowY == M - 1)  // 도착점에 도달하면
                return nowD;    // 거리값 리턴

            for(int i = 0; i < 4; i++) {    // 원숭이 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[nowZ][tmpX][tmpY])  // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 0) {  // 갈 수 있는 평지이면
                    visited[nowZ][tmpX][tmpY] = true;   // 방문
                    queue.offer(new Node(tmpX, tmpY, nowZ, nowD + 1));  // 큐에 삽입 => 찬스는 그대로, 거리는 + 1
                }
            }

            if(nowZ > 0) {  // 찬스가 있으면
                for(int i = 0; i < 8; i++) {    // 말 8방향
                    int tmpX = nowX + dx2[i], tmpY = nowY + dy2[i]; // 다음 좌표

                    if(isNotValidPos(tmpX, tmpY) || visited[nowZ - 1][tmpX][tmpY])  // 유효한지
                        continue;

                    if(map[tmpX][tmpY] == 0) {  // 갈 수 있는 평지이면
                        visited[nowZ - 1][tmpX][tmpY] = true;   // 방문
                        queue.offer(new Node(tmpX, tmpY, nowZ - 1, nowD + 1));  // 큐에 삽입 => 찬스는 - 1, 거리는 + 1
                    }
                }
            }
        }

        return -1;  // 방문할 수 없으므로 -1 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(BFS(0, 0, K, 0));    // BFS => 좌표 (0, 0), 찬스 K개, 거리 0
    }
}
