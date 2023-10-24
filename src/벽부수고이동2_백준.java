import java.io.*;
import java.util.*;

/*
6 4 2
0100
1110
1000
0000
0111
0000
 */

public class 벽부수고이동2_백준 {
    static int N, M, K; // 크기, 찬스
    static int[][] map; // 입력배열
    static boolean[][][] visited;   // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node { // 노드 클래스
        int x, y, d, z; // 좌표, 거리, 찬스
        public Node(int x, int y, int d, int z) {   // 파라미터 생성자
            this.x = x;
            this.y = y;
            this.d = d;
            this.z = z;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        K = Integer.parseInt(st.nextToken());   // 찬스

        // 초기화
        map = new int[N][M];
        visited = new boolean[K + 1][N][M];

        for (int i = 0; i < N; i++) {   // 행
            char[] ch = bf.readLine().toCharArray();    // 문자 배열로 저장

            for (int j = 0; j < M; j++) // 열
                map[i][j] = ch[j] - '0';    // 정수형 배열로 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int BFS(int x, int y, int d, int z) { // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(x, y, d, z));  // 시작점 큐에 삽입
        visited[z][x][y] = true;    // 시작점 방문

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowX = now.x, nowY = now.y, nowD = now.d, nowZ = now.z; // 현재 좌표, 거리, 찬스
            if (nowX == N - 1 && nowY == M - 1) // 도착점에 도달하면
                return nowD;    // BFS: 너비우선이므로 거리 비교 필요 X => 그대로 거리값 리턴

            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표
                if (isNotValidPos(tmpX, tmpY))  // 유효한지
                    continue;

                if (map[tmpX][tmpY] == 0) { // 거리이면
                    if (!visited[nowZ][tmpX][tmpY]) {   // 방문 가능하면
                        visited[nowZ][tmpX][tmpY] = true;   // 방문
                        queue.offer(new Node(tmpX, tmpY, nowD + 1, nowZ));  // 큐에 삽입, 거리 + 1, 찬스는 그대로
                    }
                } else if (nowZ > 0 && !visited[nowZ - 1][tmpX][tmpY]) {    // 거리가 아닌 벽이면서 찬스가 있고 다음 좌표 방문 가능하면
                    visited[nowZ - 1][tmpX][tmpY] = true;   // 방문
                    queue.offer(new Node(tmpX, tmpY, nowD + 1, nowZ - 1));  // 큐에 삽입, 거리 + 1, 찬스 - 1
                }
            }
        }

        return -1;  // 여기에 도달하면 도착하지 못하는 것이므로 -1 리턴
    }

    public static void main(String[] args) throws IOException {

        init();  // 초기화

        System.out.println(BFS(0, 0, 1, K));    // BFS, (0, 0)좌표, 거리 1, 찬스 K개
    }
}
