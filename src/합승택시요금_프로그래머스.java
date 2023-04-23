import java.util.*;

public class 합승택시요금_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, 4, 6, 2,
                new int[][] {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }

    static class Solution {

        public void Dijkstra(int v, int[] D) {  // 다익스트라
            PriorityQueue<Edge> pq = new PriorityQueue<>(); // 우선순위 큐

            pq.offer(new Edge(v, 0));   // 시작점 추가
            D[v] = 0;   // 거리 갱신

            while(!pq.isEmpty()) {  // 우선순위 큐가 비어있지않으면
                Edge now = pq.poll();   // 하나 꺼내어

                int nowNode = now.node; // 현재노드
                int nowD = now.d;   // 가중치

                for(int i = 0; i < graph[nowNode].size(); i++) {    // 인접리스트의 크기만큼
                    Edge next = graph[nowNode].get(i);  // 인접리스트

                    int nextNode = next.node;   // 노드
                    int nextD = next.d; // 가중치

                    if(D[nextNode] > D[nowNode] + nextD) {  // 최단경로 갱신
                        D[nextNode] = D[nowNode] + nextD;
                        pq.offer(new Edge(nextNode, D[nextNode]));  // 우선순위 큐에 삽입
                    }
                }
            }
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = MaxDistance;   // 최대길이로 초기화

            DA = new int[n + 1];    // a를 시작점으로
            DB = new int[n + 1];    // b
            DS = new int[n + 1];    // s

            graph = new ArrayList[n + 1];   // 그래프, 엣지리스트
            for(int i = 1; i <= n; i++) {   // 노드 개수만큼
                graph[i] = new ArrayList<Edge>();   // 인접리스트 구현

                DA[i] = MaxDistance;    // 최단경로배열
                DB[i] = MaxDistance;    // 가장 큰 수로 초기화
                DS[i] = MaxDistance;
            }

            for(int[] fare : fares) {   // 엣지 개수만큼
                int start = fare[0];    // 시작
                int end = fare[1];      // 끝
                int w = fare[2];        // 가중치

                graph[start].add(new Edge(end, w)); // 엣지리스트 저장
                graph[end].add(new Edge(start, w)); // 무방향 => 양방향
            }

            Dijkstra(a, DA);    // 다익스트라
            Dijkstra(b, DB);
            Dijkstra(s, DS);

            for(int i = 1; i <= n; i++) // 노드 개수만큼
                answer = Math.min(answer, DA[i] + DB[i] + DS[i]);   // 최소값 => 겹치는 경로가 없는 경우 => 최단경로

            return answer;
        }

        static final int MaxDistance = 200 * 10000 + 1; // 최대 길이
        static List<Edge>[] graph;  // 엣지리스트
        static int[] DA;    // a
        static int[] DB;    // b
        static int[] DS;    // s 거리배열

        // 엣지클래스 + 우선순위 큐 => Comparable 클래스 구현 => compareTo() 메소드 재정의
        static class Edge implements Comparable<Edge> {
            int node, d;    // 멤버변수

            // 멤버함수
            public Edge(int node, int d) {  // 파라미터 생성자
                this.node = node;
                this.d = d;
            }

            @Override   // 재정의
            public int compareTo(Edge e) {
                return this.d - e.d;    // 오름차순 정렬
            }
        }
    }
}
