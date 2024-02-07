public class 순위_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][] {{4, 3},
                {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    static class Solution {
        public int solution(int n, int[][] results) {

            int answer = 0; // 결과값
            int[][] dp = new int[n + 1][n + 1]; // dp 배열

            for(int[] result : results) {   // 입력배열 순회
                int s = result[0], e = result[1];   // 이긴사람 s, 진 사람 e

                dp[s][e] = 1;   // s -> e: 1
                dp[e][s] = -1;  // e -> s: -1
            }

            // 벨만포드 알고리즘
            for(int k = 1; k <= n; k++) {   // 경유지 k에 대해
                for(int i = 1; i <= n; i++) {   // 시작점에서
                    for(int j = 1; j <= n; j++) {   // 도착점으로
                        if(dp[i][k] == 1 && dp[k][j] == 1) {    // 도달 가능한 경우 1번 => i가 k를 이기고, k가 j를 이기면 i가 j를 이김
                            dp[i][j] = 1;   // i -> j: 1
                            dp[j][i] = -1;  // j -> i: -1
                        }

                        if(dp[i][k] == -1 && dp[k][j] == -1) {  // 도달 가능한 경우 2번 => i가 k에게 지고, k가 j에게 지면 i가 j에게 짐
                            dp[i][j] = -1;  // i -> j: -1
                            dp[j][i] = 1;   // j -> i: 1
                        }
                    }
                }
            }

            for(int i = 1; i <= n; i++) {   // 행
                int count = 0;  // 개수

                for(int j = 1; j <= n; j++) // 열
                    if(dp[i][j] != 0)   // 0이 아니면 => 승부를 낸 경우
                        count++;    // 개수 카운트

                if(count == n - 1)  // 자신을 제외한 개수가 같으면
                    answer++;   // 순위를 정할 수 있으므로 결과값 카운트
            }

            return answer;  // 결과값 리턴
        }
    }
}
