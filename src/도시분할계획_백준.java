import java.util.*;

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
    static int[] parent;    // 대표노드

    static class Edge implements Comparable<Edge> { // 엣지 클래스, 가중치 오름차순 정렬
        int s, e, w;    // 멤버변수

        public Edge(int s, int e, int w) {  // 생성자
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {  // 오버라이딩
            return this.w - e.w;    // 오름차순 정렬
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        parent = new int[N + 1];
        pq = new PriorityQueue<>();

        for(int i = 1; i <= N; i++) // 대표노드 설정
            parent[i] = i;

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝
            int w = sc.nextInt();   // 가중치

            pq.offer(new Edge(s, e, w));    // 우선순위 큐에 삽입
        }
    }

    public static void union(int a, int b) {    // 합집합
        a = find(a);
        b = find(b);

        if(a != b)
            parent[b] = a;
    }

    public static int find(int a) { // find
        if(a == parent[a])
            return a;

        return parent[a] = find(parent[a]);
    }

    public static void printKruskal() { // 크루스칼

        int sum = 0, count = 0;

        while(count < N - 2) { // N - 2번 실행 => 대표노드가 다른 경우에만 증가시켜야 하므로 개수 카운트
            Edge now = pq.poll(); // 하나 꺼내어

            if (find(now.s) != find(now.e)) { // 대표 노드가 다르면
                union(now.s, now.e); // 합집합
                sum += now.w; // 비용 갱신
                count++;    // 개수 카운트
            }
        }

        System.out.println(sum);   // 합 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printKruskal(); // 분할 최소값 출력
    }
}
