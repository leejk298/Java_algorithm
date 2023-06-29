import java.util.*;

public class 숫자변환하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 40, 5));
    }

    static class Solution {
        public int solution(int x, int y, int n) {

            int[] dp = new int[y + 1];  // 초기화
            for (int i = x; i < y + 1; i++) {   // x부터 y까지
                if (i != x && dp[i] == 0) { // x를 제외하고, 메모이제이션 => 이미 갱신된 인덱스
                    dp[i] = -1; // -1로 초기화

                    continue;
                }

                // 유효한 범위면 => y보다 작거나 같으면
                if (i * 2 <= y)
                    dp[i * 2] = (dp[i * 2] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 2]);

                if (i * 3 <= y)
                    dp[i * 3] = (dp[i * 3] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i * 3]);

                if (i + n <= y)
                    dp[i + n] = (dp[i + n] == 0) ? dp[i] + 1 : Math.min(dp[i] + 1, dp[i + n]);

            }

            return dp[y];
        }
    }
}
