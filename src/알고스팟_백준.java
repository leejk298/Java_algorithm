import java.util.*;
import java.io.*;

/*
6 6
001111
010000
001111
110001
011010
100010
 */

public class 알고스팟_백준 {
    static int N, M;    // 크기
    static char[][] map;    // 입력배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1 ,1};

    static class Edge implements Comparable<Edge> { // 엣지 클래스
        int s, e, w;    // 시작, 도착, 가중치

        public Edge(int s, int e, int w) {  // 파라미터 생성자
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {  // 메소드 오버라이딩
            return this.w - e.w;    // 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 열
        N = Integer.parseInt(st.nextToken());   // 행

        // 초기화
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) // 행
            map[i] = bf.readLine().toCharArray();    // 입력배열 저장
    }

    public static boolean isNotValidPos(int x, int y) {     // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void Dijkstra(int x, int y) { // 다익스트라

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Edge(x, y, 0));    // 시작점 우선순위 큐에 삽입, 개수 0부터
        visited[x][y] = true;   // 시작점부터 방문

        while (!pq.isEmpty()) { // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어 => 벽을 가장 적게 부순 객체

            int nowX = now.s, nowY = now.e, nowD = now.w;   // 현재 노드

            if(nowX == N - 1 && nowY == M - 1) {    // 도착점에 도달하면
                System.out.println(nowD);   // 최소비용 출력

                return; // 함수 종료
            }

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                visited[tmpX][tmpY] = true; // 방문

                if(map[tmpX][tmpY] == '0')  // 벽이 아니면
                    pq.offer(new Edge(tmpX, tmpY, nowD));   // 개수 그대로
                else    // 벽이면
                    pq.offer(new Edge(tmpX, tmpY, nowD + 1));   // 개수 + 1
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Dijkstra(0, 0); // 다익스트라
    }
}
