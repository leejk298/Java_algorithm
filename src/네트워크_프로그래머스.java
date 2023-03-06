public class 네트워크_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[][] {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
    }

    static class Solution {
        static boolean visited[];
        public int solution(int n, int[][] computers) {
            int answer = 0;
            visited = new boolean[computers.length];

            for(int i = 0; i < computers.length; i++) {
                if(!visited[i]) {
                    DFS(i, computers);
                    answer++;
                }
            }

            return answer;
        }

        public void DFS(int v, int[][] computers) {
            visited[v] = true;

            for(int i = 0; i < computers.length; i++)
                if(!visited[i] && computers[v][i] == 1)
                    DFS(i, computers);
        }
    }
}
