public class 순위_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][] {{4, 3},
                {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    static class Solution {
        public int solution(int n, int[][] results) {

            // 초기화
            int answer = 0;
            int[][] dp = new int[n + 1][n + 1];

            for(int i = 0; i < results.length; i++) {   // 크기만큼
                int S = results[i][0];  // 시작
                int E = results[i][1];  // 끝

                dp[S][E] = 1;   // 이기면 1
                dp[E][S] = -1;  // 지면 -1
            }

            for(int k = 1; k <= n; k++) {   // 경유지 k
                for(int i = 1; i <= n; i++) {   // 시작점부터
                    for(int j = 1; j <= n; j++) {   // 도착점까지
                        if(dp[i][k] == 1 && dp[k][j] == 1) {    // 경유지를 거쳐서 갈 수 있으면 => 둘 다 이기면
                            dp[i][j] = 1;   // 순위가 정해지므로 1
                            dp[j][i] = -1;  // 반대는 -1
                        }

                        if(dp[i][k] == -1 && dp[k][j] == -1) {  // 둘 다 졌으면
                            dp[i][j] = -1;  // 순위가 정해지므로 -1
                            dp[j][i] = 1;   // 반대는 1
                        }
                    }
                }
            }

            for(int i = 1; i <= n; i++) {   // 행
                int count = 0;  // 개수

                for(int j = 1; j <= n; j++) {   // 열
                    if(dp[i][j] != 0)   // 0이 아니면 이기거나 진 거이므로
                        count++;    // 개수 카운트
                }

                if(count == n - 1)  // 자신을 제외한 n - 1개이면 순위가 정해지므로
                    answer++;   // 결과값 카운트
            }

            return answer;  // 총 개수 리턴
        }
    }
}
