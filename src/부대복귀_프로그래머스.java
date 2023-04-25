import java.util.*;

public class 부대복귀_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[][] {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}},
                new int[] {1, 3, 5}, 5)));
    }

    static class Solution {
        static List<Integer>[] A;   // 인접리스트
        static int[] D; // 최단거리
        static final int MaxDistance = Integer.MAX_VALUE;   // 초기 거리값

        public static void Dijkstra(int v) {    // 다익스트라
            Queue<Integer> queue = new LinkedList<>();  // 큐, 우선순위큐가 아닌이유는 거리가 1로 동일하기 때문에

            queue.offer(v); // 시작점 추가
            D[v] = 0;       // 0으로 설정

            while(!queue.isEmpty()) {   // 비어있지 않으면
                int now = queue.poll(); // 하나 꺼내어

                for(int i = 0; i < A[now].size(); i++) {    // 인접리스트의 크기만큼
                    int next = A[now].get(i);   // 하나씩

                    if(D[next] > D[now] + 1) {  // 최단경로
                        D[next] = D[now] + 1;   // 설정
                        queue.offer(next);      // 큐에 추가
                    }
                }
            }
        }

        public int[] solution(int n, int[][] roads, int[] sources, int destination) {
            // 초기화
            D = new int[n + 1];
            A = new ArrayList[n + 1];

            for(int i = 1; i <= n; i++) {
                A[i] = new ArrayList<>();
                D[i] = MaxDistance;
            }

            for(int[] road : roads) {   // 인접리스트에 추가
                int S = road[0], E = road[1];

                A[S].add(E);    // 무방향
                A[E].add(S);
            }

            Dijkstra(destination);  // 다익스트라

            int[] answer = new int[sources.length]; // 결과배열
            for(int i = 0; i < answer.length; i++)  // 길이만큼
                answer[i] = (D[sources[i]] == MaxDistance) ? -1 : D[sources[i]];    // 초기값 그대로이면 갈 수 없는 경로

            return answer;  // 결과배열 리턴
        }
    }
}
