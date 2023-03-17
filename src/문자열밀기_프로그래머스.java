public class 문자열밀기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("atat", "tata"));
    }

    static class Solution {
        public int solution(String A, String B) {
            int answer = 0;
            String str = A;

            for(int i = 0; i < A.length(); i++) {
                if(str.equals(B)) {
                    return answer;
                }

                String tmp = str.substring(str.length() - 1); // N - 1부터 이후 문자열 => 마지막 문자
                str = tmp + str.substring(0, str.length() - 1); // 0 ~ N - 1 이전까지 문자열 뒤에 붙임
                answer++;   // 1 회전
            }

            return -1;
        }
    }
}
