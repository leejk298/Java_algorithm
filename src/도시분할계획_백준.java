import java.util.*;
import java.io.*;

/*
7 12
1 2 3
1 3 2
3 2 1
2 5 2
3 4 4
7 3 6
5 1 5
1 6 2
6 4 1
6 5 3
4 5 3
6 7 4
 */

public class 도시분할계획_백준 {
    static int N, M;    // 크기
    static PriorityQueue<Edge> pq;  // 우선순위 큐
    static int[] parent;    // 부모배열

    static class Edge implements Comparable<Edge> { // 내부클래스
        int S, E, W;    // 멤버변수

        public Edge(int S, int E, int W) {  // 파라미터 생성자
            this.S = S; // 시작
            this.E = E; // 도착
            this.W = W; // 가중치
        }

        @Override
        public int compareTo(Edge e) {  // 오름차순 정렬
            return this.W - e.W;    // 가중치
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        pq = new PriorityQueue<>();
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++)    // 정점 개수만큼
            parent[i] = i;  // 부모배열 저장

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작
            int e = Integer.parseInt(st.nextToken());   // 도착
            int w = Integer.parseInt(st.nextToken());   // 가중치

            pq.offer(new Edge(s, e, w));    // 우선순위 큐에 삽입
        }
    }

    public static int find(int a) { // 대표노드 찾기

        if (a == parent[a]) // 초기값과 같으면
            return a;   // 그대로 리턴

        // 다르면 부모배열도 갱신 후 리턴
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);    // 대표노드 찾기
        b = find(b);

        if (a != b) // 다르면
            parent[b] = a;  // 합집합
    }

    public static void Kruskal() {  // 크루스칼, MST 알고리즘

        int count = 0, res = 0; // 개수, 결과값 초기화

        while (count < N - 2) { // N - 2
            Edge now = pq.poll();   // 하나 꺼내어

            if (find(now.S) != find(now.E)) {   // 다르면
                union(now.S, now.E);    // 합집합
                res += now.W;   // 결과값 갱신
                count++;    // 개수 카운트
            }
        }

        System.out.println(res);    // 결과값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Kruskal();   // 크루스칼 알고리즘
    }
}
