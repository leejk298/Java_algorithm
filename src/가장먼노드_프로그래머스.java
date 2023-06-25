import java.util.*;

public class 가장먼노드_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][] {{3, 6},
                {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    static class Solution {
        static List<Integer>[] A;   // 인접리스트
        static int[] visited;   // 방문배열

        public static void BFS(int v) { // BFS

            Queue<Integer> queue = new LinkedList<>();  // 큐

            queue.offer(v); // 시작점 삽입
            visited[v] = 1; // 시작점 거리 1부터

            while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int now = queue.poll(); // 하나 꺼내어

                for(int i = 0; i < A[now].size(); i++) {    // 해당 노드의 인접리스트 순회
                    int next = A[now].get(i);   // 다음 노드

                    if(visited[next] == 0) {    // 방문한 적이 없으면
                        visited[next] = visited[now] + 1;   // 방문, 거리 + 1
                        queue.offer(next);  // 큐에 삽입
                    }
                }
            }
        }

        public int solution(int n, int[][] edge) {

            // 초기화
            int answer = 0;
            A = new ArrayList[n + 1];
            visited = new int[n + 1];

            for(int i = 0; i <= n; i++) // 인접리스트
                A[i] = new ArrayList<>();

            for(int i = 0; i < edge.length; i++) {
                A[edge[i][0]].add(edge[i][1]);  // 양방향
                A[edge[i][1]].add(edge[i][0]);
            }

            for(int i = 0; i <= n; i++)
                Collections.sort(A[i]); // 작은 노드 번호부터 순서대로 순회하기 위해

            BFS(1); // 1번 노드로 BFS => 거리배열

            Arrays.sort(visited);   // 방문겸 거리배열 정렬

            int max = visited[n];   // 가장 먼 노드의 거리
            for(int i : visited)    // 순회
                if(i == max)    // 최대 거리이면
                    answer++;   // 개수 카운트

            return answer;  // 총 개수 리턴
        }
    }
}
