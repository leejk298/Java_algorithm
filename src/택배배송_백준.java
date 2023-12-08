import java.util.*;
import java.io.*;

/*
6 8
4 5 3
2 4 0
4 1 4
2 1 1
5 6 1
3 6 2
3 2 6
3 4 4
 */

public class 택배배송_백준 {
    static int N, M;    // 크기
    static List<Node>[] A;  // 인접리스트
    static boolean[] visited;   // 방문배열
    static int[] D; // 거리배열

    static class Node implements Comparable<Node> { // 노드클래스

        // 멤버변수
        int v, w;   // 정점, 가중치

        // 멤버함수
        public Node(int v, int w) { // 파라미터 생성자
            this.v = v; // 정점
            this.w = w; // 가중치
        }

        @Override   // 메소드 오버라이딩
        public int compareTo(Node node) {   // 오름차순 정렬
            return this.w - node.w; // 가중치 순
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        A = new List[N + 1];
        visited = new boolean[N + 1];
        D = new int[N + 1];

        for (int i = 1; i <= N; i++) {  // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현
            D[i] = 50000001; // 50000 * 1000 + 1    // 거리배열 무한대로 초기화
        }

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작
            int e = Integer.parseInt(st.nextToken());   // 도착
            int w = Integer.parseInt(st.nextToken());   // 가중치

            A[s].add(new Node(e, w));   // 양방향
            A[e].add(new Node(s, w));
        }
    }

    public static int Dijkstra(int start, int end) {    // 다익스트라, 최단경로 알고리즘

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(start, 0));   // 시작점 우선순위 큐에 삽입
        D[start] = 0;   // 시작점 0부터 시작

        while (!pq.isEmpty()) { // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            int nowV = now.v;   // 현재 정점
            if (!visited[nowV]) {   // 방문한 적이 없으면
                visited[nowV] = true;   // 방문

                for (Node next : A[nowV]) { // 해당 정점의 인접리스트 순회
                    if (!visited[next.v] && D[next.v] > D[nowV] + next.w) { // 다음 정점이 방문한 적이 없고 최단경로이면
                        D[next.v] = D[nowV] + next.w;   // 갱신
                        pq.offer(new Node(next.v, D[next.v]));  // 우선순위 큐에 삽입
                    }
                }
            }
        }

        return D[end];  // 도착지까지 최소비용 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(Dijkstra(1, N)); // 다익스트라, 최단경로 출력
    }
}
