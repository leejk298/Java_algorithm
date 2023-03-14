import java.util.Arrays;

public class 연속된수의합_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(4, 14)));
    }

    static class Solution {
        public int[] solution(int num, int total) {
            int[] answer = new int[num];

            // (x + 1) + (x + 2) + ... + (x + n) 이면
            // n == num => x를 제외한 연속된 수의 합은
            int sum = num * (num + 1) / 2;  // n x (n + 1) / 2
            // x를 제외한 연속된 수의 합을 total에서 빼면 x만 남음
            // x도 nun개만큼 더해줬으므로 nun개로 나눠줌
            int x = (total - sum) / num;

            // x + 1부터 x + n까지
            for(int n = 1; n <= num; n++)
                answer[n - 1] = x + n;

            return answer;
        }
    }
}
