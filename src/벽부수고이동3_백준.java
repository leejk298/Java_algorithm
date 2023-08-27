import java.util.*;
import java.io.*;

/*
6 4 1
0100
1110
1000
0000
0111
0000
 */

public class 벽부수고이동3_백준 {
    static int N, M, K; // 크기
    static boolean[][][] visited;   // 방문배열
    static char[][] map;    // 입력배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node { // 내부 클래스
        int x, y, z, d; // 좌표, 횟수, 거리
        boolean h;  // 낮, 밤

        public Node(int x, int y, int z, int d, boolean h) {    // 파라미터 생성자
            this.x = x;
            this.y = y;
            this.z = z;
            this.d = d;
            this.h = h;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        K = Integer.parseInt(st.nextToken());   // 횟수

        // 초기화
        map = new char[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) // 행만큼
            map[i] = bf.readLine().toCharArray();   // 문자배열
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS() {  // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(0, 0, 0, 1, true));    // 시작점 큐에 삽입
        visited[0][0][0] = true;    // 시작점 방문

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            // 현재 노드
            int nowX = now.x, nowY = now.y, nowZ = now.z, nowD = now.d;
            boolean h = now.h;

            if (nowX == N - 1 && nowY == M - 1) {   // 도착점에 도달하면
                System.out.println(nowD);   // 최소 거리 출력

                return; // 함수 종료
            }

            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY))  // 유효한지
                    continue;

                if (map[tmpX][tmpY] == '0') {   // 벽이 아니면
                    if (!visited[tmpX][tmpY][nowZ]) {   // 방문 가능하면
                        visited[tmpX][tmpY][nowZ] = true;   // 방문
                        queue.offer(new Node(tmpX, tmpY, nowZ, nowD + 1, !h));  // 횟수는 그대로 거리 + 1, 낮 <-> 밤
                    }
                } else if (nowZ < K) {  // 벽이고 부술 수 있으면
                    if (h && !visited[tmpX][tmpY][nowZ + 1]) {  // 낮이고 방문 가능하면
                        visited[tmpX][tmpY][nowZ + 1] = true;   // 방문
                        queue.offer(new Node(tmpX, tmpY, nowZ + 1, nowD + 1, !h));  // 횟수 + 1, 거리 + 1, 낮 <-> 밤
                    }

                    if (!h) {   // 밤이면
                        queue.offer(new Node(nowX, nowY, nowZ, nowD + 1, !h));  // 이동 x, 거리 + 1, 낮 <-> 밤
                    }
                }
            }
        }

        System.out.println(-1); // 여기에 도달하면 도착할 수 없는 것이므로 -1 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS();  // BFS
    }
}
