public class 푸드파이터대회_프로그래머스 {
    public static void main(String[] args) {
       Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 3, 4, 6}));
    }

    static class Solution {
        public String solution(int[] food) {
            String answer = "";
            String str = "";

            for(int i = 1; i < food.length; i++) {
                for(int j = 0; j < food[i] / 2; j++) {
                    str += i;
                }
            }

            answer = str + 0;

            for(int i = str.length() - 1; i >= 0; i--)
                answer += str.substring(i, i + 1);

            return answer;
        }
    }
}
