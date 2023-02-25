public class 올바른괄호갯수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
    }

    static class Solution {
        static int answer;

        public int solution(int n) {
            answer = 0;

            dfs(0, 0, n);   // 루트

            return answer;
        }

        public void dfs(int l, int r, int N) {
            if (l < r)  // 여는 괄호 먼저
                return;

            if(l > N || r > N)  // 개수 초과
                return;

            if(l == N && r == N) {  // 알맞은 경우
                answer++;

                return;
            }

            // 왼쪽부터 => 여는 괄호 먼저
            dfs(l + 1, r, N);
            dfs(l, r + 1, N);
        }
    }
}
