import java.util.*;
import java.io.*;

/*
5 4
0010
1000
0100
0001
0100
 */
public class 벽부수고이동_백준 {
    static int N, M;    // 크기
    static boolean[][][] visited;   // 방문배열
    static int[][] map; // 입력배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node { // 노드 클래스
        int x, y, z, d;

        public Node(int x, int y, int z, int d) {   // 파라미터 생성자
            this.x = x; // 좌표
            this.y = y;
            this.z = z; // 벽 부술수 있는 찬스
            this.d = d; // 거리
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        map = new int[N][M];    // 입력배열
        visited = new boolean[2][N][M]; // 방문배열, 0: 찬스 x, 1: 찬스 o

        for (int i = 0; i < N; i++) {    // 행
            char[] ch = bf.readLine().toCharArray();    // 문자배열

            for (int j = 0; j < M; j++)  // 열
                map[i][j] = ch[j] - '0';    // 입력배열 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int BFS(int x, int y, int z, int d) { // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(x, y, z, d));  // 시작점 큐에 삽입
        visited[z][x][y] = true;    // 방문여부 갱신

        while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowX = now.x, nowY = now.y, nowZ = now.z, nowD = now.d; // 현재 노드값

            if (nowX == N - 1 && nowY == M - 1)  // 도착점에 도달하면
                return nowD;    // 현재 객체의 거리값 출력

            for (int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY))  // 유효한지
                    continue;

                if (map[tmpX][tmpY] == 0) {  // 거리이면
                    if (!visited[nowZ][tmpX][tmpY]) {   // 방문 가능하면
                        visited[nowZ][tmpX][tmpY] = true;   // 방문
                        queue.offer(new Node(tmpX, tmpY, nowZ, nowD + 1));  // 거리 + 1
                    }
                } else if (nowZ == 1) {  // 벽이고 허물 수 있으면
                    if (!visited[nowZ - 1][tmpX][tmpY]) {   // 방문 가능하면
                        visited[nowZ - 1][tmpX][tmpY] = true;   // 방문, 찬스 - 1
                        queue.offer(new Node(tmpX, tmpY, nowZ - 1, nowD + 1));  // 찬스 - 1, 거리 + 1
                    }
                }
            }
        }

        return -1;  // 여기에 도달하면 도착할 수 없는 것이므로 -1 출력
    }

    public static void main(String[] args) throws IOException {

        init();  // 초기화

        System.out.println(BFS(0, 0, 1, 1));    // BFS, 좌표(0, 0), 찬스, 거리
    }
}
