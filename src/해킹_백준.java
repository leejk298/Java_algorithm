import java.util.*;
import java.io.*;

/*
2
3 2 2
2 1 5
3 2 5
3 3 1
2 1 2
3 1 8
3 2 4
 */

public class 해킹_백준 {
    static int N, M, S; // 크기, 시작점
    static final int INF = Integer.MAX_VALUE;   // 무한대
    static List<Node>[] A;  // 인접리스트
    static int[] D; // 거리배열
    static boolean[] visited;   // 방문배열

    static class Node implements Comparable<Node> { // 노드 클래스
        int v, w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo (Node node) {  // 메소드 오버라이딩
            return this.w - node.w; // 가중치 오름차순 정렬
        }
    }

    public static void init(BufferedReader bf) throws IOException { // 초기화

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 엣지 개수
        S = Integer.parseInt(st.nextToken());   // 시작점

        // 초기화
        A = new ArrayList[N + 1];
        D = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 1; i <= N; i++) // 정점 개수만큼
            A[i] = new ArrayList<>();   // 인접리스트 구현

        Arrays.fill(D, INF);    // 거리 무한대로 초기화

        for(int i = 0; i < M; i++) {    // 엣지 개수만큼
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            int start = Integer.parseInt(st.nextToken());   // 시작
            int end = Integer.parseInt(st.nextToken());     // 도착
            int weight = Integer.parseInt(st.nextToken());  // 가중치

            A[end].add(new Node(start, weight));    // 인접리스트 저장
        }
    }

    public static void Dijkstra(int v) {    // 다익스트라

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 우선순위 큐

        D[v] = 0;   // 시작점 거리 0
        pq.offer(new Node(v, 0));   // 우선순위 큐에 시작점 저장

        while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지 않으면
            Node now = pq.poll();   // 하나 꺼내어

            int nowV = now.v;   // 현재 노드
            if(!visited[nowV]) {    // 방문한 적이 없으면
                visited[nowV] = true;   // 방문

                for(int i = 0; i < A[nowV].size(); i++) {   // 현재 노드의 인접리스트 개수만큼
                    Node next = A[nowV].get(i); // 다음 노드

                    int nextV = next.v, nextW = next.w; // 정점과 가중치
                    if(D[nextV] > D[nowV] + nextW) {    // 최단경로이면
                        D[nextV] = D[nowV] + nextW; // 갱신
                        pq.offer(new Node(nextV, D[nextV]));    // 우선순위 큐에 삽입
                    }
                }
            }
        }
    }

    public static void printResult(StringBuilder sb) {  // 결과 출력

        int count = 0, time = 0;    // 개수, 시간

        for(int i = 1; i <= N; i++) {   // 정점 개수만큼
            if(D[i] != INF) {   // 거리가 갱신되었으면
                count++;    // 개수 카운트
                time = Math.max(time, D[i]);    // 걸린 시간
            }
        }

        sb.append(count + " " + time + "\n");   // 결과문자열에 저장
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringBuilder sb = new StringBuilder(); // 결과문자열

        int T = Integer.parseInt(bf.readLine());    // 테스트케이스 개수

        while(T-- > 0) {    // 테스트케이스 개수만큼
            init(bf);   // 초기화

            Dijkstra(S);    // 다익스트라

            printResult(sb);    // 결과문자열
        }

        System.out.print(sb);   // 결과 출력
    }
}
