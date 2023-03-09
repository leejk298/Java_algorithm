public class 타일링_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    static class Solution {
        public long solution(int n) {
            long answer = 0;
            int mod = 1000000007;
            long[] tile = new long[5001];

            tile[0] = 1;
            tile[2] = 3;

            for (int i = 4; i <= n; i += 2) {
                tile[i] = tile[i - 2] * 3;
                for (int j = i - 4; j >= 0; j--) {
                    tile[i] += tile[j] * 2;
                }

                tile[i] %= mod;
            }

            return answer = tile[n];
        }
    }
}
