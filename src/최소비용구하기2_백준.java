import java.util.*;

/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
 */

public class 최소비용구하기2_백준 {
    static int N, M, start, end;    // 크기, 시작, 도착점
    static List<Edge>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] D, route;  // 거리, 경로배열

    static class Edge implements Comparable<Edge> { // 내부 클래스
        // 엣지리스트 -> 우선순위 큐 -> 가중치 오름차순 정렬 -> Comparable 인터페이스 구현 -> compareTo() 메소드 구현
        int v, w;   // 멤버 변수

        public Edge(int v, int w) { // 생성자
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge e) {  // 오버라이딩
            return this.w - e.w;    // 가중치 오름차순 정렬
        }
    }

    public static void init() { // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 정점
        M = sc.nextInt();   // 엣지

        // 초기화
        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];
        route = new int[N + 1];

        for(int i = 1; i <= N; i++) {   // 노드 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현
            D[i] = 100000001;   // 거리배열 무한대로 초기화, 100,000 * 1,000 + 1
        }

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            int s = sc.nextInt();   // 시작
            int e = sc.nextInt();   // 끝
            int w = sc.nextInt();   // 가중치

            A[s].add(new Edge(e, w));   // 인접리스트 저장
        }

        start = sc.nextInt();   // 출발
        end = sc.nextInt();     // 도착
    }

    public static void Dijkstra() { // 다익스트라

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Edge(start, 0));   // 시작점 삽입
        D[start] = 0;   // 거리 0으로 시작
        route[start] = 0;   // 시작점 이전 경로는 0번 노드

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Edge now = pq.poll();   // 하나 꺼내어

            if(!visited[now.v]) {   // 방문한 적이 없으면
                visited[now.v] = true;  // 방문여부 갱신

                for(int i = 0; i < A[now.v].size(); i++) {  // 인접리스트 순회
                    Edge next = A[now.v].get(i);    // 다음 정점

                    if(D[next.v] > D[now.v] + next.w) { // 최단경로이면
                        D[next.v] = D[now.v] + next.w;  // 갱신
                        route[next.v] = now.v;  // 이전 경로 저장
                        pq.offer(new Edge(next.v, D[next.v]));  // 우선순위 큐에 삽입
                    }
                }
            }
        }
    }

    public static void printAll() { // 출력

        System.out.println(D[end]); // 최소비용 출력

        List<Integer> list = new ArrayList<>(); // 경로리스트

        int next = end; // 도착점부터 시작해서 역으로
        while(next != 0) {  // 다음 노드가 0이 아니면
            list.add(next); // 경로 추가
            next = route[next]; // 다음 노드 갱신
        }

        System.out.println(list.size());    // 총 길이 출력

        for(int i = list.size() - 1; i >= 0; i--)   // 길이만큼
            System.out.print(list.get(i) + " ");    // 경로 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        Dijkstra(); // 다익스트라

        printAll(); // 출력
    }
}
