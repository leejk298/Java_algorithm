public class 피로도_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
    }

    static class Solution {
        static int answer;  // 결과값
        static boolean[] visited;   // 방문배열

        public static void DFS(int count, int k, int[][] d) {   // DFS

            answer = Math.max(answer, count);   // 최대값 설정

            for(int i = 0; i < d.length; i++) { // 크기만큼
                if(d[i][0] <= k && !visited[i]) {   // 필요 피로도보다 크거나 같고 방문한 적이 없으면
                    visited[i] = true;  // 방문
                    DFS(count + 1, k - d[i][1], d); // DFS, 횟수 1개 카운트

                    visited[i] = false; // 리턴되면 방문 여부 갱신
                }
            }
        }

        public int solution(int k, int[][] dungeons) {

            // 초기화
            answer = -1;
            visited = new boolean[dungeons.length];

            DFS(0, k, dungeons);    // DFS, 횟수, 총 피로도

            return answer;  // 결과값 출력
        }
    }
}
