import java.util.*;
import java.io.*;

/*
4 6
1 2 3
2 3 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
 */

public class 특정한최단경로_백준 {
    static int N, M, v1, v2;    // 크기, 정점
    static final int INF = 200000000;   // 무한대
    static ArrayList<Node>[] A; // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] D; // 거리배열

    static class Node implements Comparable<Node> { // 노드 클래스
        int v, w;   // 정점, 가중치

        public Node(int v, int w) { // 파라미터 생성자
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {   // 가중치
            return this.w - node.w;     // 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        A = new ArrayList[N + 1];   // 초기화

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            A[S].add(new Node(E, W));  // 양방향
            A[E].add(new Node(S, W));
        }

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        v1 = Integer.parseInt(st.nextToken());  // 정점1
        v2 = Integer.parseInt(st.nextToken());  // 정점2
    }

    public static void initArray() {    // 배열 초기화

        // 초기화
        visited = new boolean[N + 1];  // 방문배열
        D = new int[N + 1]; // 거리배열

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            D[i] = INF; // 무한대로 초기화
    }

    public static int Dijkstra(int start, int end) {    // 다익스트랑

        initArray();    // 배열 초기화

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(start, 0));   // 시작점 우선순위 큐에 삽입
        D[start] = 0;   // 시작점 거리 0부터

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            int nowV = now.v;   // 현재 정점
            if (!visited[nowV]) {   // 방문한 적이 없으면
                visited[nowV] = true;   // 방문

                for (int i = 0; i < A[nowV].size(); i++) {  // 인접리스트 개수만큼
                    Node next = A[nowV].get(i); // 다음 노드

                    int nextV = next.v, nextW = next.w; // 정점, 가중치
                    if (D[nextV] > D[nowV] + nextW) {   // 최단 경로면
                        D[nextV] = D[nowV] + nextW;     // 갱신
                        pq.offer(new Node(nextV, D[nextV]));    // 우선순위 큐에 삽입
                    }
                }
            }
        }

        return D[end];  // 도착점까지의 최단거리
    }

    public static void printPath() {    // 최단경로 출력

        int result1 = 0, result2 = 0;   // 경로1, 2

        // 1 -> v1 -> v2 -> N
        result1 += Dijkstra(1, v1);
        result1 += Dijkstra(v1, v2);
        result1 += Dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N
        result2 += Dijkstra(1, v2);
        result2 += Dijkstra(v2, v1);
        result2 += Dijkstra(v1, N);

        if(result1 >= INF && result2 >= INF)    // 도달 불가능
            System.out.println(-1); // -1 출력
        else    // 도달 가능
            System.out.println(Math.min(result1, result2)); // 최단거리 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        printPath();    // 최단경로 출력
    }
}
