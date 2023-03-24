public class 멀리뛰기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    static class Solution {
        public long solution(int n) {
            long[] answer = new long[2001];
            int mod = 1234567;

            answer[1] = 1;
            answer[2] = 2;

            for(int i = 3; i < 2001; i++)
                answer[i] = (answer[i - 1] + answer[i - 2]) % mod;

            return answer[n];
        }
    }
}
