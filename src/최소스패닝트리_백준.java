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
    static PriorityQueue<Edge> pq;  // 우선순위 큐

    static class Edge implements Comparable<Edge> { // 엣지리스트
        int S, E, W;    // 시작, 도착, 가중치

        public Edge(int S, int E, int W) {  // 파라미터 생성자
            this.S = S;
            this.E = E;
            this.W = W;
        }

        @Override
        public int compareTo(Edge e) {  // 가중치 오름차순 정렬
            return this.W - e.W;
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

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            parent[i] = i;  // 부모배열 저장

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int start = Integer.parseInt(st.nextToken());   // 시작
            int end = Integer.parseInt(st.nextToken());     // 도착
            int weight = Integer.parseInt(st.nextToken());  // 가중치

            pq.offer(new Edge(start, end, weight)); // 우선순위 큐에 저장
        }
    }

    public static int find(int a) { // 대표노드 찾기

        if (a == parent[a]) // 부모와 같으면
            return a;   // 그대로

        return parent[a] = find(parent[a]); // 다르면 부모까지 갱신 후 리턴
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);    // 대표노드 a, b
        b = find(b);

        if (a != b) // 다르면
            parent[a] = b;  // 합집합
    }

    public static void Kruskal() {  // 크루스칼 알고리즘 => MST

        int res = 0;    // 결과값

        while (!pq.isEmpty()) { // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            int nowS = now.S, nowE = now.E; // 시작, 도착
            if (find(nowS) != find(nowE)) { // 대표노드가 다르면
                union(nowS, nowE);  // 합집합
                res += now.W;   // 결과값 갱신
            }
        }

        System.out.println(res);    // 결과값 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Kruskal();  // 크루스칼
    }
}
