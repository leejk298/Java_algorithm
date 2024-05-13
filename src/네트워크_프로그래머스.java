public class 네트워크_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    static class Solution {
        public static void DFS(int v, boolean[] visited, int[][] computers) {   // DFS

            // 베이스케이스
            if (visited[v])  // 방문한 적이 있으면
                return; // 리턴

            // 재귀케이스: 방문한 적이 없으면
            visited[v] = true;  // 방문 여부 갱신

            for (int i = 0; i < computers[v].length; i++) {  // 해당 노드에서
                if (i == v)  // 출발지와 도착지가 같으면
                    continue; // 건너뛰기
                else if (computers[v][i] == 1 && !visited[i])    // 갈 수 있는 경우
                    DFS(i, visited, computers); // DFS
            }
        }

        public int solution(int n, int[][] computers) {

            int answer = 0; // 결과값
            boolean[] visited = new boolean[n]; // 방문 배열

            for (int i = 0; i < n; i++) {    // 크기만큼
                if (!visited[i]) {   // 방문하지 않았으면
                    DFS(i, visited, computers); // DFS
                    answer++;   // 연결요소 카운트
                }
            }

            return answer;  // 총 연결요소 개수 리턴
        }
    }
}
