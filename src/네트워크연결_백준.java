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
    static PriorityQueue<Edge> pq;  // 우선순위 큐, 엣지클래스 (크루스칼 - MST) <-> 노드클래스 (다익스트라 - 최단경로)
    static int[] parent;    // 부모배열

    static class Edge implements Comparable<Edge> { // 엣지클래스, 우선순위 큐 => Comparable 클래스 구현 => compareTo() 메소드 재정의
        int s, e, w;    // 시작, 도착, 가중치

        public Edge(int s, int e, int w) {  // 파라미터 생성자
            this.s = s; // 시작점
            this.e = e; // 도착점
            this.w = w; // 가중치
        }

        @Override
        public int compareTo(Edge e) {  // 오버라이딩
            return this.w - e.w;    // 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수

        st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        pq = new PriorityQueue<>(); // 우선순위 큐 구현
        parent = new int[N + 1];    // 대표노드 초기화

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            parent[i] = i;  // 부모배열 저장

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            pq.offer(new Edge(S, E, W));    // 우선순위 큐에 저장 => 가중치 오름차순 정렬
        }
    }

    public static int find(int a) { // find()

        if(a == parent[a])  // 베이스케이스: 초기화 상태이면
            return a;   // 그대로

        // 재귀케이스: 다르면 부모배열도 갱신 후 리턴
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);  // 부모
        b = find(b);

        if(a != b)  // 다르면
            parent[b] = a;  // 합집합
    }

    public static void Kruskal() {  // 크루스칼 - MST 알고리즘

        int res = 0;    // 결과값

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            if(find(now.s) != find(now.e)) {    // 서로 부모노드가 다르면
                union(now.s, now.e);    // 합집합
                res += now.w;   // 결과값 갱신
            }
        }

        System.out.println(res);    // 최소값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Kruskal();  // 크루스칼
    }
}
