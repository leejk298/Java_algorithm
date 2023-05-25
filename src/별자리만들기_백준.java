import java.util.*;

/*
3
1.0 1.0
2.0 2.0
2.0 4.0
 */

public class 별자리만들기_백준 {
    static int N;   // 크기
    static int[] parent;   // 부모배열, 대표노드
    static Node[] star;     // 별배열, 정점리스트
    static PriorityQueue<Edge> pq;  // 엣지리스트

    static class Node { // 별
        int num;    // 인덱스
        double x, y;    // 좌표

        public Node(int num, double x, double y) {  // 생성자
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> { // 엣지클래스
        int s, e;   // 노드
        double w;   // 가중치

        public Edge(int s, int e, double w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {  // 오버라이딩
            return this.w < e.w ? -1 : 1;       // 오름차순 정렬
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기

        // 초기화
        star = new Node[N + 1];
        parent = new int[N + 1];
        pq = new PriorityQueue<>();

        for (int i = 1; i <= N; i++)    // 대표노드 설정
            parent[i] = i;

        for (int i = 1; i <= N; i++) {  // 정점 개수만큼
            double x = sc.nextDouble(); // 좌표
            double y = sc.nextDouble();

            star[i] = new Node(i, x, y);    // 정점리스트 저장
        }

        for (int i = 1; i < N; i++) // 한 정점에서
            for (int j = i + 1; j <= N; j++)    // 다른 정점으로 가는
                pq.offer(new Edge(i, j, Math.sqrt(Math.pow(star[i].x - star[j].x, 2) +
                        Math.pow(star[i].y - star[j].y, 2))));  // 모든 거리 계산, 거리 오름차순으로 정렬
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

        double sum = 0; // 최소비용

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            if(find(now.s) != find(now.e)) {    // 서로 대표노드가 다르면
                union(now.s, now.e);    // 합집합
                sum += now.w;   // 최소비용 갱신
            }
        }

        System.out.println(Math.round(sum * 100) / 100.0);  // 소수 둘째자리까지 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        Kruskal();  // 크루스칼
    }
}
