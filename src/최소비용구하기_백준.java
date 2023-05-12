import java.util.*;

/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
 */


public class 최소비용구하기_백준 {
    static int N, M, start, end;    // 크기, 시작, 끝
    static List<Node>[] A;  // 인접리스트
    static int[] D; // 거리배열
    static boolean[] visited;   // 방문배열

    static class Node implements Comparable<Node> { // 노드 클래스 => Comparable 인터페이스 구현 => compareTo() 메소드 재정의
        int v, w;   // 노드, 가중치

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {   // 재정의
            return this.w - node.w; // 가중치 오름차순 정렬
        }
    }

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];

        for(int i = 1; i <= N; i++) {   // 노드 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현
            D[i] = Integer.MAX_VALUE;   // 거리배열 무한대로 설정
        }

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int S = sc.nextInt();   // 시작
            int E = sc.nextInt();   // 끝
            int W = sc.nextInt();   // 가중치

            A[S].add(new Node(E, W));   // 단방향
        }

        start = sc.nextInt();   // 시작점
        end = sc.nextInt();     // 끝점
    }

    public static void Dijkstra(int v) {    // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(v, 0));   // 시작점 추가
        D[v] = 0;   // 거리 0으로 갱신

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어
            int nowV = now.v, nowW = now.w; // 현재 노드와 가중치

            if(D[nowV] < nowW)  // 최단경로가 아니면
                continue;   // 건너뛰기

            if(!visited[nowV])  // 방문여부 갱신
                visited[nowV] = true;

            for(int i = 0; i < A[nowV].size(); i++) {   // 인접리스트 개수만큼
                Node tmp = A[nowV].get(i);  // 하나씩 순회하여
                int nextV = tmp.v, weight = tmp.w;  // 다음노드와 가중치

                if(!visited[nextV] && (D[nextV] > D[nowV] + weight)) { // 방문한 적이 없고 최단경로이면
                    D[nextV] = D[nowV] + weight;    // 최단경로 갱신
                    pq.offer(new Node(nextV, D[nextV]));    // 우선순위 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        Dijkstra(start);    // 시작점으로 다익스트라

        System.out.println(D[end]); // 끝점 비용 출력
    }
}
