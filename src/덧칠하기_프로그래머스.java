public class 덧칠하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, 4, new int[] {1, 3}));
    }

    static class Solution {
        public int solution(int n, int m, int[] section) {
            int answer = 0, max = 0;

            for(int i = 0; i < section.length; i++) {
                if(section[i] >= max) {
                    answer += 1;
                    max = section[i] + m;
                }
            }

            return answer;
        }
    }
}
