import java.util.*;

/*
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0
 */

public class 녹색옷입은애_백준 {
    static int N;   // 크기
    static int[][] map, D;  // 맵, 거리배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> { // 내부클래스
        int x, y, w;

        public Node(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node v) {  // 오버라이딩
            return this.w - v.w;    // 오름차순
        }
    }

    public static void init(Scanner sc) {   // 초기화

        // 초기화
        map = new int[N][N];
        D = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();   // 맵 저장
                D[i][j] = N * N * 9 + 1;    // 무한대로 초기화
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void Dijkstra() { // 다익스트라

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(0, 0, map[0][0]));    // 시작점 삽입
        D[0][0] = map[0][0];    // 시작점 거리 갱신

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나꺼내어

            int nowX = now.x, nowY = now.y; // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(D[tmpX][tmpY] > D[nowX][nowY] + map[tmpX][tmpY]) {   // 최소비용이면
                    D[tmpX][tmpY] = D[nowX][nowY] + map[tmpX][tmpY];    // 갱신
                    pq.offer(new Node(tmpX, tmpY, D[tmpX][tmpY]));      // 우선순위 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        int count = 1;  // 횟수
        while(true) {

            N = sc.nextInt();   // N

            if(N == 0)  // 0 이면 종료
                break;

            init(sc);   // 초기화

            Dijkstra(); // 다익스트라

            System.out.println("Problem " + count++ + ": " + D[N - 1][N - 1]);  // 최소비용 출력
        }
    }
}
