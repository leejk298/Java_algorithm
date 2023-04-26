import java.util.*;
import java.io.*;

/*
6 4
0100
1110
1000
0000
0111
0000
 */
public class 벽부수고이동_백준 {
    private static int N, M;    // 크기
    private static int[][] map; // 맵
    private static boolean[][][] visited;   // 방문배열, 벽 부순것까지 고려
    private static int[][] D;   // 최단거리
    private static int[] dx = {-1, 1, 0, 0};    // 상하좌우
    private static int[] dy = {0, 0, -1, 1};    // 4방향

    public static void init() throws IOException {  // 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M][2];
        D = new int[N][M];

        for(int i = 0; i < N; i++) {    // 행
            char[] ch = bf.readLine().toCharArray();

            for (int j = 0; j < M; j++) {   // 열
                map[i][j] = ch[j] - '0';    // 문자 -> 정수
            }
        }
    }

    public static boolean notValidPos(int x, int y) {   // 유효한 좌표
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static boolean BFS() {   // BFS
        Queue<Node> queue = new LinkedList<>();  // 큐

        queue.offer(new Node(0, 0, 1)); // 시작점 삽입
        visited[0][0][0] = true;    // 방문배열 갱신
        D[0][0] = 1;    // 최단거리

        while(!queue.isEmpty()) {   // 큐가 비어있지않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowX = now.x;   // 좌표
            int nowY = now.y;
            int nowZ = now.z;   // 벽 부순지 체크

            if(nowX == N - 1 && nowY == M - 1)  // 도착하면
                return true;    // true 리턴

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i];
                int tmpY = nowY + dy[i];

                if(notValidPos(tmpX, tmpY) || visited[tmpX][tmpY][nowZ])    // 좌표가 유효하지않거나 방문한 경우
                    continue;   // 건너뛰기

                if(map[tmpX][tmpY] == 0) {  // 0 인 경우
                    visited[tmpX][tmpY][nowZ] = true;
                    D[tmpX][tmpY] = D[nowX][nowY] + 1;
                    queue.offer(new Node(tmpX, tmpY, nowZ));
                } else if(nowZ == 1) {  // 벽인데 1개는 부술 수 있는 경우
                    visited[tmpX][tmpY][nowZ] = true;
                    D[tmpX][tmpY] = D[nowX][nowY] + 1;
                    queue.offer(new Node(tmpX, tmpY, nowZ - 1));
                }
            }
        }

        return false;   // 도착하지 못하면 false 리턴
    }

    static class Node { // Node 클래스
        int x, y, z;

        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException{

        init(); // 초기화

        if(BFS())   // BFS, 도착하면
            System.out.print(D[N - 1][M - 1]);
        else    // 도착하지 못하면
            System.out.print(-1);
    }
}
