import java.util.Arrays;

public class 우박수열정적분_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(5, new int[][] {{0, 0}, {0, -1}, {2, -3}, {3, -3}})));
    }

    static class Solution {
        public double[] solution(int k, int[][] ranges) {
            double[] answer = new double[ranges.length];

            int count = cnt(k); // 횟수
            int[] pos = new int[count + 1]; // 좌표
            double[] sum = new double[count + 1];   // 누적합

            pos[0] = k; // (0, k)
            for(int i = 1; i <= count; i++)
                pos[i] = getPos(pos[i - 1]);

            sum[1] = ((double)pos[0] + pos[1]) / 2; // 0 - 1 합
            for(int i = 2; i <= count; i++)
                sum[i] = sum[i - 1] + ((double)pos[i - 1] + pos[i]) / 2;

            for(int i = 0; i < ranges.length; i++) {
                int S = ranges[i][0];       // 시작
                int E = count + ranges[i][1];   // 끝

                if(S > E)   // 시작이 더 크면 -1
                    answer[i] = -1;
                else if(S < E)  // 끝이 더 크면
                    answer[i] = sum[E] - sum[S];    // 구간 합
                else    // 같으면 0
                    answer[i] = 0;
            }

            return answer;
        }

        static int getPos(int n) {  // 좌표
            if(n % 2 == 0)
                n /= 2;
            else
                n = n * 3 + 1;

            return n;
        }

        static int cnt(int k) { // 횟수
            int count = 0;

            while(k != 1) {
                if(k % 2 == 0)
                    k /= 2;
                else
                    k = k * 3 + 1;

                count++;
            }

            return count;
        }
    }
}
