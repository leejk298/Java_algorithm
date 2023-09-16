import java.util.*;

public class 전력망둘로나누기1_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }

    static class Solution {
        static int answer;  // 결과값
        static int count;   // 송전탑 개수
        static boolean[] visited;   // 방문배열
        static List<Integer>[] A;   // 인접리스트

        public static void DFS(int x, int y) {  // DFS

            visited[x] = true;  // 방문 여부 갱신
            count++;    // 송전탑 개수 카운트

            for (int i = 0; i < A[x].size(); i++) {  // 해당 노드의 인접 리스트 개수만큼
                int next = A[x].get(i); // 다음 노드

                if (next != y && !visited[next]) // 다음 노드가 y가 아니면서 방문한 적이 없으면
                    DFS(next, y);   // DFS
            }
        }

        public int solution(int n, int[][] wires) {
            // 초기화
            answer = n - 2; // 최대 개수는 n - 2 => 자신 빼면

            A = new ArrayList[n + 1];   // 인접리스트
            for (int i = 1; i <= n; i++)
                A[i] = new ArrayList<>();

            for (int i = 0; i < wires.length; i++) { // 크기만큼
                A[wires[i][0]].add(wires[i][1]);    // 양방향
                A[wires[i][1]].add(wires[i][0]);
            }

            // 연결된 두 노드로 DFS 수행시켜 각각의 연결요소 개수를 파악해 가장 차이가 적은 것 출력
            for (int i = 0; i < wires.length; i++) {    // 크기만큼
                visited = new boolean[n + 1];   // 방문배열 초기화
                count = 0;  // 개수 초기화

                DFS(wires[i][0], wires[i][1]);  // DFS
                int count1 = count; // 개수1 저장

                visited = new boolean[n + 1];
                count = 0;

                DFS(wires[i][1], wires[i][0]);
                int count2 = count; // 개수2 저장

                answer = Math.min(answer, Math.abs(count1 - count2));   // 최소값 저장
            }

            return answer;  // 최소값 출력
        }
    }
}
