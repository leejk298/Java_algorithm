public class 거스름돈_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[] {1, 2, 5}));
    }

    static class Solution {
        public int solution(int n, int[] money) {
            int[] answer = new int[n + 1];

            answer[0] = 1;
            for(int i = 0; i < money.length; i++) {
                for(int j = money[i]; j <= n; j++) {
                    answer[j] += answer[j - money[i]];
                    answer[j] %= 1000000007;
                }
            }

            return answer[n];
        }
    }
}
