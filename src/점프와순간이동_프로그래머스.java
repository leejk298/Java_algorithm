public class 점프와순간이동_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5000));
    }

    static class Solution {
        public int solution(int n) {
            int answer = 0;

            while(n != 0) {
                if(n % 2 == 0)
                    n /= 2;
                else {
                    n--;
                    answer++;
                }
            }

            return answer;
        }
    }
}
