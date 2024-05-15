public class 거스름돈_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[]{1, 2, 5}));
    }

    static class Solution {
        public int solution(int n, int[] money) {

            int[] answer = new int[n + 1];  // 결과배열

            answer[0] = 1;  // 1부터 시작

            for (int i = 0; i < money.length; i++) { // 길이만큼
                for (int j = money[i]; j <= n; j++) {    // n 만큼
                    answer[j] += answer[j - money[i]];  // 거스름돈 더하기
                    answer[j] %= 1000000007;
                }
            }

            return answer[n];   // 총 결과값 리턴
        }
    }
}
