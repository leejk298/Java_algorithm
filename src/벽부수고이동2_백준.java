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
    static int N, M, K, D;  // 크기, 거리
    static int[][] map; // 맵
    static boolean[][][] visited;   // 방문배열, 벽 부수는 것도 고려
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        K = Integer.parseInt(st.nextToken());   // 부술수 있는 횟수

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M][K + 1]; // K번 가능

        for(int i = 0; i < N; i++) {    // 행
            String str = bf.readLine(); // 한 줄 스트링

            for(int j = 0; j < M; j++) {    // 열
                map[i][j] = str.charAt(j) - '0';    // 정수형으로 변환하여 저장
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static boolean BFS() {   // BFS
        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(0, 0, 1, 0));  // 거리 1부터, 시작점 삽입
        visited[0][0][0] = true;    // 방문여부 갱신, 벽 부수는거 0

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowX = now.x, nowY = now.y, nowD = now.d, nowW = now.w;

            if(nowX == N - 1 && nowY == M - 1) {    // 도착이면
                D = nowD;   // 최단거리 저장

                return true;    // true 리턴
            }

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 벽, 1인 경우
                    if(nowW < K && !visited[tmpX][tmpY][nowW + 1]) {    // K 번까지 가능
                        visited[tmpX][tmpY][nowW + 1] = true;   // 방문여부 갱신
                        queue.offer(new Node(tmpX, tmpY, nowD + 1, nowW + 1));   // 큐에 삽입
                    }
                } else {    // 0
                    if(!visited[tmpX][tmpY][nowW]) {    // 벽 부수기 x
                        visited[tmpX][tmpY][nowW] = true;
                        queue.offer(new Node(tmpX, tmpY, nowD + 1, nowW));
                    }
                }
            }
        }

        return false;   // 여기로 오면 도달 x 이므로 false 리턴
    }

    static class Node { // 내부 클래스로 구현, Node
        int x, y, d, w; // 좌표, 거리, 부수는 횟수

        public Node(int x, int y, int d, int w) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        if(BFS())   // 도달하면
            System.out.print(D);    // 최단거리 출력
        else    // 도달하지 못하면
            System.out.print(-1);   // -1 출력
    }
}
