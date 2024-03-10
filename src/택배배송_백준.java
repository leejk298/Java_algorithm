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
        int v, w;   // 정점, 가중치

        public Node(int v, int w) { // 파라미터 생성자
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Node node) {   // 메소드 오버라이딩
            return this.w - node.w; // 가중치 오름차순 정렬
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수

        // 초기화
        A = new List[N + 1];    // 인접리스트
        visited = new boolean[N + 1];   // 방문배열
        D = new int[N + 1]; // 거리배열

        for (int i = 1; i <= N; i++) {  // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현
            D[i] = 50000 * 1000 + 1;    // 최대값으로 초기화
        }

        for (int i = 0; i < M; i++) {   // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int s = Integer.parseInt(st.nextToken());   // 시작점
            int e = Integer.parseInt(st.nextToken());   // 도착점
            int w = Integer.parseInt(st.nextToken());   // 가중치

            A[s].add(new Node(e, w));   // 양방향
            A[e].add(new Node(s, w));
        }
    }

    public static void Dijkstra(int s, int e) { // 다익스트라 알고리즘

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        pq.offer(new Node(s, 0));   // 시작점 우선순위 큐에 삽입
        D[s] = 0;   // 시작점 거리 0

        while (!pq.isEmpty()) { // 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            int nowV = now.v, nowW = now.w; // 현재 노드값
            if (!visited[nowV]) {   // 방문한 적이 없으면
                visited[nowV] = true;   // 방문

                for (Node next : A[nowV]) { // 해당 정점의 인접리스트 순회
                    if (!visited[next.v] && D[next.v] > D[nowV] + next.w) { // 다음 정점을 방문한 적이 없고 최단 경로이면
                        D[next.v] = D[nowV] + next.w;   // 최단경로 갱신
                        pq.offer(new Node(next.v, D[next.v]));  // 우선순위 큐에 삽입
                    }
                }
            }
        }

        System.out.println(D[e]);   // 도착점까지의 최단경로 값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        Dijkstra(1, N); // 다익스트라 알고리즘 - 최단경로
    }
}
