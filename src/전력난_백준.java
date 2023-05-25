import java.util.*;

/*
7 11
0 1 7
0 3 5
1 2 8
1 3 9
1 4 7
2 4 5
3 4 15
3 5 6
4 5 8
4 6 9
5 6 11
0 0
 */

public class 전력난_백준 {
    static int N, M, sum;   // 크기, 총 합
    static int[] parent;    // 대표노드, 부모배열
    static PriorityQueue<Edge> pq;  // 엣지리스트, 우선순위 큐

    static class Edge implements Comparable<Edge> { // 엣지 클래스
        int s, e, w;    // 노드, 가중치

        public Edge(int s, int e, int w) {  // 생성자
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {  // 오버라이딩
            return this.w - e.w;    // 오름차순
        }
    }

    public static void init(Scanner sc) {   // 초기화

        // 초기화
        pq = new PriorityQueue<>();
        parent = new int[N];
        sum = 0;

        for(int i = 0; i < N; i++)  // 정점 개수만큼
            parent[i] = i;  // 대표노드 저장

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 정점
            int e = sc.nextInt();
            int w = sc.nextInt();   // 가중치

            pq.offer(new Edge(s, e, w));    // 우선순위 큐에 삽입
            sum += w;   // 총 비용
        }
    }

    public static int find(int a) { // find

        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }

    public static void Kruskal() {  // 크루스칼

        int cost = 0;   // 최소비용

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            if(find(now.s) != find(now.e)) {    // 대표노드가 다르면
                union(now.s, now.e);    // 합집합
                cost += now.w;  // 최소비용 저장
            }
        }

        System.out.println(sum - cost); // 남는 비용
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);    // 입력

        while (true) {

            N = sc.nextInt();   // 정점
            M = sc.nextInt();   // 엣지

            if(N == 0 && M == 0)    // 둘 다 0이면, while 탈출
                break;

            init(sc);   // 초기화

            Kruskal();  // 크루스칼
        }
    }
}
