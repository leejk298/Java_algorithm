public class 모음사전_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("EIO"));
    }

    static class Solution {
        public int solution(String word) {
            int answer = 0;
            String str = "AEIOU";
            int total = 3905;

            for(String s : word.split("")) {
                total /= 5;
                answer += total * str.indexOf(s) + 1;
            }

            return answer;
        }
    }
}
