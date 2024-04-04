import java.util.*;

public class 가장먼노드_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][]{{3, 6},
                {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    static class Solution {
        static List<Integer>[] A;   // 인접리스트
        static int[] visited;   // 방문배열

        public static void init(int n, int[][] edge) {  // 초기화

            A = new ArrayList[n + 1];   // 인접리스트
            visited = new int[n + 1];   // 방문배열

            for (int i = 0; i <= n; i++) // 개수만큼
                A[i] = new ArrayList<>();   // 인접리스트 구현

            for (int i = 0; i < edge.length; i++) {  // 입력배열 길이만큼
                A[edge[i][0]].add(edge[i][1]);  // 양방향
                A[edge[i][1]].add(edge[i][0]);
            }

            for (int i = 0; i <= n; i++) // 개수만큼
                Collections.sort(A[i]); // 작은 노드 번호부터 순서대로 순회하기 위해
        }

        public static void BFS(int v) { // BFS

            Queue<Integer> queue = new LinkedList<>();  // 큐

            queue.offer(v); // 시작점 삽입
            visited[v] = 1; // 시작점 거리 1부터

            while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int now = queue.poll(); // 하나 꺼내어

                for (int i = 0; i < A[now].size(); i++) {    // 해당 노드의 인접리스트 순회
                    int next = A[now].get(i);   // 다음 노드

                    if (visited[next] == 0) {    // 방문한 적이 없으면
                        visited[next] = visited[now] + 1;   // 방문, 거리 + 1
                        queue.offer(next);  // 큐에 삽입
                    }
                }
            }
        }

        public static int getAnswer(int n) {    // 결과값

            Arrays.sort(visited);   // 방문겸 거리배열 정렬

            int answer = 0, max = visited[n];   // 가장 먼 노드의 거리

            for (int i : visited)    // 순회
                if (i == max)    // 최대 거리이면
                    answer++;   // 개수 카운트

            return answer;  // 결과값 리턴
        }

        public int solution(int n, int[][] edge) {

            init(n, edge);  // 초기화

            BFS(1); // 1번 노드로 BFS => 거리배열

            return getAnswer(n);  // 총 개수 리턴
        }
    }
}
