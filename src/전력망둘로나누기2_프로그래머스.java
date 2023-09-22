import java.util.*;

public class 전력망둘로나누기2_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }

    static class Solution {
        static List<Integer>[] A;   // 인접리스트
        static boolean[] visited;   // 방문배열

        public static int BFS(int x, int y) {   // BFS

            Queue<Integer> queue = new LinkedList<>();  // 큐
            int count = 0;  // 송전탑 개수

            queue.offer(x); // 시작점 삽입
            visited[x] = true;  // 시작점 방문 여부 갱신
            count++;    // 개수 카운트

            while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int now = queue.poll(); // 하나 꺼내어
                for(int i = 0; i < A[now].size(); i++) {    // 해당 노드의 인접리스트 개수만큼
                    int next = A[now].get(i);   // 다음 노드

                    if(next != y && !visited[next]) {   // 다음 노드가 y가 아니면서 방문한 적이 없는 노드이면
                        visited[next] = true;   // 방문
                        count++;    // 개수 카운트
                        queue.offer(next);  // 큐에 삽입
                    }
                }
            }

            return count;   // 송전탑 개수 리턴
        }

        public int solution(int n, int[][] wires) {
            // 초기화
            int answer = n - 2; // 결과값, 최대 n - 2: 자신빼면
            A = new ArrayList[n + 1];   // 인접리스트
            for(int i = 1; i <= n; i++)
                A[i] = new ArrayList<>();

            for(int i = 0; i < wires.length; i++) { // 크기만큼
                A[wires[i][0]].add(wires[i][1]);    // 양방향
                A[wires[i][1]].add(wires[i][0]);
            }

            // 연결된 두 노드로 BFS 수행시켜 각각의 연결요소 개수를 파악해 가장 차이가 적은 것 출력
            for(int i = 0; i < wires.length; i++) { // 크기만큼
                visited = new boolean[n + 1];   // 방문 배열 초기화
                int count1 = BFS(wires[i][0], wires[i][1]); // BFS

                visited = new boolean[n + 1];   // 방문 배열 초기화
                int count2 = BFS(wires[i][1], wires[i][0]); // BFS

                answer = Math.min(answer, Math.abs(count1 - count2));   // 최소값 저장
            }

            return answer;  // 최소값 출력
        }
    }
}
