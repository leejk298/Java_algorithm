public class 등굣길_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, 3, new int[][] {{2, 2}}));
    }

    static public class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[][] dp = new int[n + 1][m + 1];

            dp[1][1] = 1; // 시작위치를 1로 초기화
            for (int[] puddle : puddles) //웅덩이들 -1로 초기화
                dp[puddle[1]][puddle[0]] = -1;

            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    if (dp[i][j] == -1) // 웅덩이는 0 으로
                        dp[i][j] = 0;
                    else {
                        if (i == 1)
                            dp[i][j] += dp[i][j - 1];
                        else
                            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                    }

                    if (j == dp[i].length - 1)
                        answer = dp[i][j];
                }
            }

            return answer;
        }
    }
}
