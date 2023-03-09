public class 점찍기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1, 5));
    }

    static class Solution {
        public long solution(int k, int d) {
            long answer = 0;
            long powD = (long)Math.pow(d, 2);

            for(int i = 0; i <= d; i += k) {
                long powX = (long) i * i;
                long y = (int)Math.sqrt(powD - powX);
                answer += y / k + 1;
            }

            return answer;
        }
    }
}
