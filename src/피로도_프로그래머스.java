public class 피로도_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}}));
    }

    static class Solution {
        static int answer = 0;
        static boolean[] visited;

        public int solution(int k, int[][] dungeons) {
            visited = new boolean[dungeons.length];

            DFS(0, k, dungeons);

            return answer;
        }

        static void DFS(int depth, int k, int[][] d) {
            for(int i = 0; i < d.length; i++) {
                if(!visited[i] && k >= d[i][0]) {
                    visited[i] = true;

                    DFS(depth + 1, k - d[i][1], d);
                    visited[i] = false;
                }
            }

            answer = Math.max(answer, depth);
        }
    }
}
