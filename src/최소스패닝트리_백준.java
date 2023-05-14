import java.util.*;

/*
3 3
1 2 1
2 3 2
1 3 3
 */

public class 최소스패닝트리_백준 {
    static int N, M;    // 크기
    static int[] parent;    // 부모배열, 대표노드
    static PriorityQueue<Edge> pq;  // 우선순위 큐 => 엣지리스트

    static class Edge implements Comparable<Edge> { // 엣지 클래스 => Comparable 인터페이스 구현 => compareTo() 메소드 재정의
        int S, E, W;    // 멤버변수

        public Edge(int S, int E, int W) {  // 생성자
            this.S = S;
            this.E = E;
            this.W = W;
        }

        @Override
        public int compareTo(Edge e) {  // 오버라이딩
            return this.W - e.W;    // 오름차순 정렬
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 노드
        M = sc.nextInt();   // 엣지

        // 초기화
        pq = new PriorityQueue<>();
        parent = new int[N + 1];

        for(int i = 1; i <= N; i++) // 노드 개수만큼
            parent[i] = i;  // 대표노드 초기화

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝
            int w = sc.nextInt();   // 가중치

            pq.offer(new Edge(s, e, w));    // 우선순위 큐 삽입
        }
    }

    public static void union(int a, int b) {    // 합집합

        a = find(a);    // 대표노드 찾기
        b = find(b);

        if(a < b)   // 작은 값으로 저장
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static int find(int a) { // find

        if(a == parent[a])  // 같으면 그대로
            return a;

        return parent[a] = find(parent[a]); // 다르면 부모노드로 바꾸고 리턴
    }

    public static void printMinWeight() {   // 최소가중치값 출력

        int min = 0;    // 최소값

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            if(find(now.S) != find(now.E)) {    // 다르면
                union(now.S, now.E);    // 합집합
                min += now.W;   // 최소값 갱신
            }
        }

        System.out.println(min);    // 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        printMinWeight();   // 최소비용 출력
    }
}
