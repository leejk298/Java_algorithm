import java.util.*;
import java.io.*;

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
    static int[][] map, D;  // 입력, 거리배열
    static int[] dx = {-1, 1, 0, 0};    //  4방향
    static int[] dy = {0, 0, -1, 1};

    static class Node implements Comparable<Node> { // 노드클래스
        int x, y, w;    // 좌표, 가중치

        public Node(int x, int y, int w) {  // 파라미터 생성자
            this.x = x;
            this.y = y;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {   // 메소드 오버라이딩
            return this.w - node.w; // 가중치 오름차순 정렬
        }
    }

    public static void init(BufferedReader bf) throws IOException { // 초기화

        map = new int[N][N];    // 입력배열
        D = new int[N][N];      // 거리배열

        for (int i = 0; i < N; i++) {   // 행
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < N; j++) {   // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
                D[i][j] = N * N * 9 + 1;    // 거리배열 무한대로 초기화
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static int Dijkstra() {  // 다익스트라 알고리즘

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(0, 0, map[0][0]));    // 시작점 우선순위 큐에 삽입
        D[0][0] = map[0][0];    // 시작점 거리 초기화

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            int nowX = now.x, nowY = now.y; // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(D[tmpX][tmpY] > D[nowX][nowY] + map[tmpX][tmpY]) {   // 최단경로이면
                    D[tmpX][tmpY] = D[nowX][nowY] + map[tmpX][tmpY];    // 갱신
                    pq.offer(new Node(tmpX, tmpY, D[tmpX][tmpY]));  // 우선순위 큐에 삽입
                }
            }
        }

        return D[N - 1][N - 1]; // 최단경로 값 리턴
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        int num = 1;    // 반복 횟수

        while (true) {
            N = Integer.parseInt(bf.readLine());    // 크기

            if (N == 0) // 0이면 while 종료
                break;

            init(bf);   // 초기화

            System.out.println("Problem " + num + ": " + Dijkstra());   // 출력, 다익스트라 - 최단경로 알고리즘

            num++;  // 반복 횟수 카운트
        }
    }
}
