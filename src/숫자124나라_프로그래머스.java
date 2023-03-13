public class 숫자124나라_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }

    static class Solution {
        public String solution(int n) {
            String answer = "";
            String[] str = {"4", "1", "2"}; // index 고려

            while(n > 0) {
                int num = n % 3;
                n /= 3;

                if(num == 0)
                    n--;

                answer = str[num] + answer;
            }

            return answer;
        }
    }
}
