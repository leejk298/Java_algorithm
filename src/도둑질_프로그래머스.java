public class 도둑질_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 2, 3, 1}));
    }

    static class Solution {
        public int solution(int[] money) {
            int length = money.length;
            int dp[][] = new int[2][length];

            dp[0][0] = dp[0][1] = money[0];
            dp[1][1] = money[1];

            for(int i = 2; i < length; i++) {
                dp[0][i] = Math.max(dp[0][i - 2] + money[i], dp[0][i - 1]);
                dp[1][i] = Math.max(dp[1][i - 2] + money[i], dp[1][i - 1]);
            }

            return Math.max(dp[0][length - 2], dp[1][length - 1]);
        }
    }
}
