public class 문자열나누기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("abracadabra"));
    }

    static class Solution {
        public int solution(String s) {
            int answer = 0;
            int count = 0, dif = 0;
            char ch = s.charAt(0);

            for(int i = 0; i < s.length(); i++) {
                if(count == dif) {
                    ch = s.charAt(i);
                    answer++;
                }

                if(ch == s.charAt(i)) {
                    count++;
                } else {
                    dif++;
                }
            }

            return answer;
        }
    }
}
