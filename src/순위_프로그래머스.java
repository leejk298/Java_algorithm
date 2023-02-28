public class 순위_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[][] {{4, 3},
                {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }

    static class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;
            int[][] arr = new int[n + 1][n + 1];

            for(int i = 0; i < results.length; i++) {
                int s = results[i][0];
                int e = results[i][1];

                arr[s][e] = 1;
                arr[e][s] = -1;
            }

            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    for(int k = 1; k <= n; k++) {
                        if(arr[i][k] == 1 && arr[k][j] == 1) {
                            arr[i][j] = 1;
                            arr[j][i] = -1;
                        }

                        if(arr[i][k] == -1 && arr[k][j] == -1) {
                            arr[i][j] = -1;
                            arr[j][i] = 1;
                        }
                    }
                }
            }

            for(int[] i : arr) {
                int count = 0;

                for(int j : i) {
                    if(j != 0)
                        count++;
                }

                if(count == n - 1)
                    answer++;
            }

            return answer;
        }
    }
}
