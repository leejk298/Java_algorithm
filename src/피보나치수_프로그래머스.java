public class 피보나치수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }

    static class Solution {
        public int solution(int n) {
            int[] answer = new int[n + 1];
            int mod = 1234567;

            answer[0] = 0;
            answer[1] = 1;

            for(int i = 2; i <= n; i++) {
                int sum = answer[i - 2] + answer[i - 1];
                answer[i] = sum % mod;
            }

            return answer[n];
        }
    }
}
