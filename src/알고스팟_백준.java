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
    static int N, M, count; // 크기
    static int[][] map, D;  // 맵, 거리배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> { // 내부 클래스
        int x, y, c;

        public Node(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public int compareTo(Node v) {  // 오버라이딩
            return this.c - v.c;    // 오름차순
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 열
        N = Integer.parseInt(st.nextToken());   // 행
        count = 0;  // 벽 부순 개수

        // 초기화
        map = new int[N][M];
        D = new int[N][M];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                D[i][j] = Integer.MAX_VALUE;    // 거리배열 무한대로 초기화

        // 맵 저장
        for(int i = 0; i < N; i++) {
            char[] ch = bf.readLine().toCharArray();

            for(int j = 0; j < M; j++)
                map[i][j] = ch[j] - '0';
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void Dijkstra() { // 다익스트라

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(0, 0, 0));    // 시작점 삽입
        D[0][0] = 0;    // 시작점 거리 0

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            int nowX = now.x, nowY = now.y; // 좌표
            if(nowX == N - 1 && nowY == M - 1) {    // 도착하면
                count = now.c;  // 벽 부순 횟수 저장

                return; // 함수 종료
            }

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(D[tmpX][tmpY] > D[nowX][nowY] + map[tmpX][tmpY]) {   // 최소 벽 부순 비용이면
                    D[tmpX][tmpY] = D[nowX][nowY] + map[tmpX][tmpY];    // 갱신
                    pq.offer(new Node(tmpX, tmpY, D[tmpX][tmpY]));      // 우선순위 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Dijkstra(); // 다익스트라

        System.out.println(count);  // 벽 부순 횟수 출력
    }
}
