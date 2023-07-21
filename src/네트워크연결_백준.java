import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
6
9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
 */

public class 네트워크연결_백준 {
    static int N, M;    // 크기
    static int[] parent;    // 대표배열
    static boolean[] visited;   // 방문배열
    static PriorityQueue<Edge> pq;  // 우선순위 큐

    static class Edge implements Comparable<Edge> { // 엣지클래스, 가중치 오름차순 정렬 => 우선순위 큐
        int S, E, W;    // 시작, 도착, 가중치

        public Edge(int S, int E, int W) {  // 파라미터 생성자
            this.S = S;
            this.E = E;
            this.W = W;
        }

        @Override
        public int compareTo(Edge e) {  // 오버라이딩
            return this.W - e.W;    // 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 정점 개수
        M = Integer.parseInt(bf.readLine());    // 엣지 개수

        // 초기화
        pq = new PriorityQueue<>(); // 우선순위 큐
        parent = new int[N + 1];    // 대표배열
        visited = new boolean[N + 1];   // 방문배열

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            parent[i] = i;  // 대표배열 저장

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            pq.offer(new Edge(S, E, W));    // 우선순위 큐에 삽입, 가중치 오름차순으로 정렬
        }
    }

    public static int find(int a) { // find

        if(a == parent[a])  // 대표노드가 그대로이면
            return a;   // 그대로 리턴

        // 다르면 대표노드 타고 가서 해당 대표노드도 갱신
        return parent[a] = find(parent[a]); // 갱신 후 리턴
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);    // 대표노드 찾기
        b = find(b);

        if(a != b)  // 다르면
            parent[b] = a;  // 합집합
    }

    public static void Kruskal() {  // 크루스칼, MST 알고리즘

        int res = 0;    // 최소비용

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            if(find(now.S) != find(now.E)) {    // 서로 다르면
                union(now.S, now.E);    // 합집합
                res += now.W;   // 최소비용 갱신
            }
        }

        System.out.println(res);    // 최소비용 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Kruskal();  // 크루스칼, MST 알고리즘
    }
}
