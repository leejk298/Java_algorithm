public class 숫자의표현_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(15));
    }

    static class Solution {
        public int solution(int n) {
            int s = 1, e = 1, count = 1, sum = 1;

            while(n != e) {
                if(sum == n) {
                    count++;
                    e++;
                    sum += e;
                } else if(sum > n) {
                    sum -= s;
                    s++;
                } else {
                    e++;
                    sum += e;
                }
            }

            return count;
        }
    }
}
