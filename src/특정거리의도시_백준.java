import java.util.*;

/*
4 4 2 1
1 2
1 3
2 3
2 4
 */

public class 특정거리의도시_백준 {
    static int N, M, K, X;  // 크기, 특정거리, 시작점
    static int[] D; // 거리배열
    static List<Node>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열

    // Node 클래스 => Comparable 인터페이스 구현 => compareTo() 메소드재정의
    static class Node implements Comparable<Node> { // 내부클래스
        int num, w;

        public Node(int num, int w) {
            this.num = num;
            this.w = w;
        }

        @Override
        public int compareTo(Node v) {  // 재정의
            return this.w - v.w;
        }
    }

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드개수
        M = sc.nextInt();   // 엣지개수
        K = sc.nextInt();   // 특정거리
        X = sc.nextInt();   // 시작위치

        // 초기화
        D = new int[N + 1];
        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for(int i = 1; i <= N; i++) {   // 1부터 N까지
            A[i] = new ArrayList<>();   // 인접리스트 구현
            D[i] = 300001;  // 최대값으로 초기화
        }

        for(int i = 0; i < M; i++) {    // 엣지개수만큼
            int S = sc.nextInt();   // 시작
            int E = sc.nextInt();   // 끝

            A[S].add(new Node(E, 1));   // 인접리스트 저장
        }
    }

    public static void Dijkstra(int v) {    // 다익스트라
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        D[v] = 0;   // 시작점 0 으로 초기화
        pq.offer(new Node(v, 0));   // 큐에 삽입

        while(!pq.isEmpty()) {  // 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어
            int nowNode = now.num;  // 노드

            if(!visited[nowNode])   // 방문하지 않았으면
                visited[nowNode] = true;    // 방문여부 갱신

            for(int i = 0; i < A[nowNode].size(); i++) {    // 인접리스트 크기만큼
                Node next = A[nowNode].get(i);  // 하나씩 순회하여

                int nextNode = next.num;    // 다음 노드
                int w = next.w; // 거리

                if(!visited[nextNode] && D[nextNode] > D[nowNode] + w) {    // 방문하지않았고, 최단경로이면
                    D[nextNode] = D[nowNode] + w;   // 값 갱신
                    pq.offer(new Node(nextNode, D[nextNode]));  // 큐에 삽입
                }
            }
        }
    }

    public static void print() {    // 출력

        List<Integer> list = new ArrayList<>(); // 결과리스트

        for (int i = 1; i <= N; i++)    // 노드개수만큼
            if (D[i] == K)  // 특정거리이면
                list.add(i);    // 추가

        if (list.size() == 0)   // 추가된 노드가 없으면
            System.out.println(-1); // -1 출력
        else {  // 있으면
            for (int i : list)  // 하나씩
                System.out.println(i);  // 출력
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        Dijkstra(X);    // 다익스트라

        print();    // 출력
    }
}
