public class JadenCase문자열_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("aBC DEF  3A2b "));
    }

    static class Solution {
        public String solution(String s) {

            String answer = ""; // 결과문자열

            String[] str = s.split(" "); // 공백기준으로 문자열 나누기
            for (int i = 0; i < str.length; i++) {  // 배열 크기만큼
                if (str[i].equals("")) {    // 공백이 연속인 경우
                    answer += " ";  // 공백 하나만 추가 후

                    continue;   // 건너뛰기
                }

                // 공백이 아닌경우
                answer += str[i].substring(0, 1).toUpperCase(); // 처음만 대문자
                answer += str[i].substring(1, str[i].length()).toLowerCase();   // 나머진 소문자

                answer += " ";  // 공백 추가
            }

            if (s.charAt(s.length() - 1) == ' ')    // 입력문자열 마지막이 공백이면
                return answer;  // 그대로 리턴

            // 아니면
            return answer.substring(0, answer.length() - 1);    // 공백 제거 후 리턴
        }
    }
}
