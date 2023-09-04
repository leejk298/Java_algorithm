import java.util.*;
import java.io.*;

/*
5
11 -15 -15
14 -5 -15
-1 -1 -5
10 -4 -1
19 -4 19
 */

public class 행성터널_백준 {
    static int N;   // 크기
    static PriorityQueue<Edge> pq;  // 우선순위 큐
    static int[] parent;    // 부모배열
    static Planet[] planet; // 행성배열

    static class Planet {   // 행성 클래스
        int index, x, y, z; // 인덱스, 좌표

        public Planet(int index, int x, int y, int z) { // 파라미터 생성자
            this.index = index;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge> { // 엣지 클래스
        int s, e, w;

        public Edge(int s, int e, int w) {
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

        N = Integer.parseInt(st.nextToken());   // 크기

        // 초기화
        planet = new Planet[N];
        parent = new int[N];
        pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {   // 크기만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int x = Integer.parseInt(st.nextToken());   // 좌표
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planet[i] = new Planet(i, x, y, z); // 행성배열 저장
        }

        Arrays.sort(planet, (o1, o2) -> o1.x - o2.x);   // x 기준 오름차순 정렬
        for (int i = 0; i < N - 1; i++) // 크기만큼
            pq.offer(new Edge(planet[i].index, planet[i + 1].index, Math.abs(planet[i].x - planet[i + 1].x)));  // 우선순위 큐에 삽입

        Arrays.sort(planet, (o1, o2) -> o1.y - o2.y);   // y 기준
        for (int i = 0; i < N - 1; i++)
            pq.offer(new Edge(planet[i].index, planet[i + 1].index, Math.abs(planet[i].y - planet[i + 1].y)));

        Arrays.sort(planet, (o1, o2) -> o1.z - o2.z);   // z 기준
        for (int i = 0; i < N - 1; i++)
            pq.offer(new Edge(planet[i].index, planet[i + 1].index, Math.abs(planet[i].z - planet[i + 1].z)));

        for (int i = 0; i < N; i++) // 크기만큼
            parent[i] = i;  // 부모배열 저장
    }

    public static int find(int a) { // find()

        if (a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);
        b = find(b);

        if (a != b)
            parent[b] = a;
    }

    public static void Kruskal() {  // 크루스칼 - MST 알고리즘

        int res = 0;    // 결과값

        while (!pq.isEmpty()) { // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            if (find(now.s) != find(now.e)) {   // 다르면
                union(now.s, now.e);    // 합집합
                res += now.w;   // 결과값 갱신
            }
        }

        System.out.println(res);    // 결과값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Kruskal();  // 크루스칼
    }
}
