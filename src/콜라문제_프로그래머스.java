public class 콜라문제_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, 1, 20));
    }

    static class Solution {
        public int solution(int a, int b, int n) {
            int answer = 0;

            while(true) {
                if(a > n)
                    break;

                answer += (n / a) * b;
                n = (n / a) * b + (n % a);
            }

            return answer;
        }
    }
}
