public class 예상대진표_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(8, 4, 7));
    }

    static class Solution {
        public int solution(int n, int a, int b) {
            int answer = 0;

            while(true) {
                a = a / 2 + a % 2;
                b = b / 2 + b % 2;
                answer++;

                if(a == b)
                    break;
            }

            return answer;
        }
    }
}
