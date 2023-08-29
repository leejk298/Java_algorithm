import java.util.*;
import java.io.*;

/*
3 3
1 2 1
2 3 2
1 3 3
 */

public class 최소스패닝트리_백준 {
    static int N, M;    // 크기
    static int[] parent;    // 부모배열
    static PriorityQueue<Edge> pq;  // 우선순위 큐, 엣지클래스 => 그래프 표현

    static class Edge implements Comparable<Edge> { // 엣지클래스, 우선순위 큐 => Comparable 클래스 구현 => compareTo() 메소드 재정의
        int s, e, w;

        public Edge(int s, int e, int w) {  // 파라미터 생성자
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {  // 메소드 오버라이딩
            return this.w - e.w;    // 가중치 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        parent = new int[N + 1];
        pq = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            parent[i] = i;  // 부모배열 저장

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int S = Integer.parseInt(st.nextToken());   // 시작
            int E = Integer.parseInt(st.nextToken());   // 도착
            int W = Integer.parseInt(st.nextToken());   // 가중치

            pq.offer(new Edge(S, E, W));    // 우선순위 큐에 삽입, 가중치 오름차순 정렬(최소힙)
        }
    }

    public static int find(int a) { // find()

        if(a == parent[a])  // 부모와 동일하면
            return a;   // 그대로 리턴

        // 다르면 부모배열 갱신 후 리턴
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);    // a의 부모
        b = find(b);    // b의 부모

        if(a != b)  // 다르면
            parent[b] = a;  // 합집합
    }

    public static void Kruskal() {  // 크루스칼, MST 알고리즘

        int res = 0;    // 최소값

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 현재 노드

            if(find(now.s) != find(now.e)) { // 시작과 도착이 다르면
                union(now.s, now.e);    // 합집합
                res += now.w;   // 가중치 합, 최소값 저장
            }
        }

        System.out.println(res);    // 최소비용 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Kruskal();  // 크루스칼
    }
}
