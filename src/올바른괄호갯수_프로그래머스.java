public class 올바른괄호갯수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3));
    }
    static class Solution {
        static int answer;  // 결과값
        public int solution(int n) {

            answer = 0; // 초기화

            DFS(0, 0, n);   // DFS

            return answer;  // 결과값 리턴
        }
        public void DFS(int l, int r, int N) { // DFS

            if (l < r)  // 여는 괄호 먼저
                return;

            if(l > N || r > N)  // 개수 초과
                return;

            if(l == N && r == N) {  // 알맞은 경우
                answer++;

                return;
            }
            // 왼쪽부터 => 여는 괄호 먼저
            DFS(l + 1, r, N);
            DFS(l, r + 1, N);
        }
    }
}
