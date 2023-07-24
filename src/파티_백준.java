import java.util.*;
import java.io.*;

/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
 */

public class 파티_백준 {
    static int N, M, X; // 크기, 시작점
    static List<Node>[] A;  // 인접리스트
    static List<Node>[] reverseA;   // 역순
    static int[] D; // 거리배열
    static int[] reverseD;  // 역순
    static boolean[] visited;   // 방문배열

    static class Node implements Comparable<Node> { // 노드클래스
        int V, W;   // 정점, 가중치

        public Node(int V, int W) { // 파라미터 생성자
            this.V = V;
            this.W = W;
        }

        @Override
        public int compareTo(Node node) {   // 오버라이딩
            return this.W - node.W; // 가중치 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수
        X = Integer.parseInt(st.nextToken());   // 시작 정점

        // 초기화
        A = new List[N + 1];
        reverseA = new List[N + 1];
        D = new int[N + 1];
        reverseD = new int[N + 1];

        for(int i = 1; i <= N; i++) {   // 정점 개수만큼
            A[i] = new ArrayList<>();   // 순방향
            reverseA[i] = new ArrayList<>();    // 역순
            D[i] = Integer.MAX_VALUE;   // 거리
            reverseD[i] = Integer.MAX_VALUE;    // 역순
        }

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            A[S].add(new Node(E, W));   // 방향 그래프
            reverseA[E].add(new Node(S, W));    // 역순
        }
    }

    public static void Dijkstra(List<Node>[] A, int v, int[] D) {   // 다익스트라, 최단경로 알고리즘

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(v, 0));   // 시작점 우선순위 큐에 삽입
        D[v] = 0;   // 시작점 거리 0부터 시작

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            if(!visited[now.V]) {   // 방문하지 않았으면
                visited[now.V] = true;  // 방문

                for(int i = 0; i < A[now.V].size(); i++) {  // 인접리스트 크기만큼
                    Node next = A[now.V].get(i);    // 다음 노드

                    if(D[next.V] > D[now.V] + next.W) { // 최단경로이면
                        D[next.V] = D[now.V] + next.W;  // 갱신
                        pq.offer(new Node(next.V, D[next.V]));  // 우선순위 큐에 삽입
                    }
                }
            }
        }
    }

    public static void printLongestPath() {    // 최대경로 출력

        int max = 0;    // 최대값

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            max = Math.max(max, D[i] + reverseD[i]);    // 왕복거리 계산

        System.out.println(max);    // 최대값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        visited = new boolean[N + 1];   // 초기화
        Dijkstra(A, X, D);  // 순 방향

        visited = new boolean[N + 1];
        Dijkstra(reverseA, X, reverseD);    // 역순

        printLongestPath();    // 왕복거리 최대값
    }
}
