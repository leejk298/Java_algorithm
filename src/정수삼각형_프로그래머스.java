public class 정수삼각형_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }

    static class Solution {
        public int solution(int[][] triangle) {

            int[][] dp = new int[triangle.length][triangle.length]; // dp 배열

            dp[0][0] = triangle[0][0];  // 초기화
            for (int i = 1; i < triangle.length; i++) { // 두 번째 행부터
                // 1. 왼쪽
                dp[i][0] = dp[i - 1][0] + triangle[i][0];
                // 2. 중간
                for (int j = 1; j <= i; j++)    // 행 개수 만큼
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                // 3. 오른쪽
                dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
            }

            int answer = 0; // 결과값
            for (int i = 0; i < triangle.length; i++)
                answer = Math.max(answer, dp[triangle.length - 1][i]);  // 맨 밑층 최대값

            return answer;  // 결과값 리턴
        }
    }
}
