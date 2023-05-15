import java.util.*;

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */

public class 최단경로_백준 {
    static int N, M, K, INF;    // 크기
    static List<Node>[] A;      // 인접리스트
    static boolean[] visited;  // 방문배열
    static int[] D;             // 거리배열

    static class Node implements Comparable<Node> { // 노드 클래스
        // (가중치 그래프 => 노드클래스 생성) + (우선순위 큐 => Comparable 클래스 구현(compareTo 메소드 재정의))
        int V, W;   // 멤버 변수

        public Node(int V, int W) { // 생성자
            this.V = V;
            this.W = W;
        }

        @Override
        public int compareTo(Node e) {  // 메소드 재정의
            return this.W - e.W;    // 오름차순 정렬
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지
        K = sc.nextInt();   // 시작점
        INF = 10 * (N - 1) + 1; // 최대거리 초기화

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];

        for(int i = 1; i <= N; i++) {   // 노드 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 생성
            D[i] = INF;                 // 거리 무한대로 설정
        }

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝
            int w = sc.nextInt();   // 가중치

            A[s].add(new Node(e, w));   // 인접리스트 구현
        }
    }

    public static void Dijkstra(int v) {    // 다익스트라

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(v, 0));   // 시작점 삽입
        D[v] = 0;   // 시작점 0

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            int nowV = now.V;   // 현재 노드
            if(!visited[nowV])  // 방문하지 않았으면
                visited[nowV] = true;   // 방문여부 갱신

            for(int i = 0; i < A[nowV].size(); i++) {   // 인접리스트 개수만큼
                Node next = A[nowV].get(i); // 전부 순회

                int nextV = next.V; // 다음 노드
                int nextW = next.W; // 다음 노드 가는데 드는 비용
                if(D[nextV] > D[nowV] + nextW) {    // 최단경로이면
                    D[nextV] = D[nowV] + nextW;     // 갱신
                    pq.offer(new Node(nextV, D[nextV]));    // 우선순위 큐에 삽입
                }
            }
        }
    }

    public static void printShortestPath() {    // 최단경로 출력

        for(int i = 1; i <= N; i++) {   // 노드 개수만큼
            if(visited[i])  // 방문하였으면
                System.out.println(D[i]);   // 거리 출력
            else    // 방문하지 않았으면, 도달 불가능이므로
                System.out.println("INF");  // INF 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        Dijkstra(K);    // 다익스트라

        printShortestPath();    // 최단경로 출력
    }
}
