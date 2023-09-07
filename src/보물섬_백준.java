import java.util.*;
import java.io.*;

/*
5 7
WLLWWWL
LLLWLLL
LWLWLWW
LWLWLLL
WLLWLWW
 */

public class 보물섬_백준 {
    static int N, M;    // 크기
    static char[][] map;    // 입력배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node { // 내부 클래스
        int x, y, d;    // 좌표, 거리

        public Node(int x, int y, int d) {  // 파라미터 생성자
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new char[N][M];
        for(int i = 0; i < N; i++)  // 행
            map[i] = bf.readLine().toCharArray();   // 입력배열 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int BFS(int x, int y) {   // BFS

        Queue<Node> queue = new LinkedList<>(); // 큐

        queue.offer(new Node(x, y, 0)); // 시작 좌표와 거리 0인 노드 객체를 큐에 삽입
        visited[x][y] = true;   // 시작점부터 방문
        int distance = 0;   // 거리 0 => 종료 조건이 없으므로 따로 관리

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Node now = queue.poll();    // 하나 꺼내어

            int nowX = now.x, nowY = now.y, nowD = now.d;   // 현재 좌표, 거리
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 'L') {    // 육지면
                    distance = Math.max(distance, nowD + 1);    // 거리 갱신 => 보물 찾기
                    visited[tmpX][tmpY] = true; // 방문
                    queue.offer(new Node(tmpX, tmpY, nowD + 1));    // 큐에 삽입
                }
            }
        }

        return distance;    // 시작점으로부터 가장 먼 거리 리턴
    }

    public static void printShortestPath() {    // 보물이 위치한 거리 출력

        int max = 0;    // 거리

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 'L') {  // 육지면
                    visited = new boolean[N][M];    // 방문배열 초기화
                    int res = BFS(i, j);    // BFS, 해당 좌표에 가장 먼 거리
                    max = Math.max(max, res);   // 가장 먼 거리 저장
                }
            }
        }

        System.out.println(max);    // 최대 거리 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printShortestPath();    // 보물이 있는 최소 경로값 출력
    }
}
