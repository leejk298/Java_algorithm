import java.util.*;
import java.io.*;

public class 최단경로_다익스트라_056 {
    static int N, M, K; // 크기
    static List<Node>[] A;  // 인접리스트
    static int[] D; // 거리배열
    static boolean[] visited;   // 방문배열

    // (가중치 그래프 => 노드클래스 생성) + (우선순위 큐 => Comparable 클래스 구현(compareTo 메소드 재정의))
    static class Node implements Comparable<Node> { // 내부 클래스
        // 멤버변수
        int v;
        int w;

        // 멤버함수
        public Node(int v, int w) { // 파라미터 생성자
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node V) { // 메소드 오버라이딩
            return this.w - V.w;    // 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 노드
        M = Integer.parseInt(st.nextToken()); // 엣지

        A = new ArrayList[N + 1]; // 인접리스트
        D = new int[N + 1]; // 최단경로배열
        visited = new boolean[N + 1]; // 방문배열

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            A[i] = new ArrayList<Node>(); // 인접리스트 구현
            D[i] = Integer.MAX_VALUE; // 최단경로배열 초기화
        }

        st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
        K = Integer.parseInt(st.nextToken()); // 출발 노드

        for (int i = 0; i < M; i++) { // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken()); // 시작
            int E = Integer.parseInt(st.nextToken()); // 끝
            int W = Integer.parseInt(st.nextToken()); // 가중치

            A[S].add(new Node(E, W)); // 가중치가 방향그래프 -> 노드클래스 생성
        }
    }

    public static void Dijkstra() { // 다익스트라

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.add(new Node(K, 0)); // 출발노드 추가
        D[K] = 0; // 시작점 거리 0

        while (!pq.isEmpty()) { // 우선순위 큐가 비어있지않으면 -> 최단경로 배열값이 가장 작은 노드 꺼내기
            Node now = pq.poll(); // 하나 꺼내어
            int nowNode = now.v; // 해당 노드

            if (!visited[nowNode])
                visited[nowNode] = true; // 방문한 노드가 아니면 방문여부 갱신

            for (int i = 0; i < A[nowNode].size(); i++) { // 해당 노드의 인접리스트의 크기만큼
                Node tmp = A[nowNode].get(i); // 인접리스트
                int next = tmp.v; // 노드
                int weight = tmp.w; // 가중치

                if (D[next] > D[nowNode] + weight) { // 최단경로 갱신
                    D[next] = D[nowNode] + weight;
                    pq.add(new Node(next, D[next])); // 우선순위 큐에 삽입
                }
            }
        }
    }

    public static void printShortestPath() {    // 최단경로 출력

        for (int i = 1; i <= N; i++) { // 노드 개수만큼
            if (visited[i]) // 방문한 배열이면
                System.out.println(D[i]); // 출발노드로부터 해당노드까지의 최단거리 출력
            else
                System.out.println("INF");
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Dijkstra(); // 다익스트라

        printShortestPath();    // 최단경로 출력
    }
}