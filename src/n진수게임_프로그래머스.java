public class n진수게임_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 4, 2, 1));
    }

    static class Solution {
        public String solution(int n, int t, int m, int p) {
            StringBuilder sb = new StringBuilder();
            StringBuilder answer = new StringBuilder();

            int num = 0;
            while(sb.length() < m * t)  // 총 반복 횟수 = 총 인원 x 미리 구할 수 갯수
                sb.append(Integer.toString(num++, n));  // toString(num, n): num를 n진법으로

            for(int i = p - 1; i < m * t; i += m)   // 튜브의 첫 순서부터 마지막까지
                answer.append(sb.charAt(i));    // 튜브가 말할 숫자

            return answer.toString().toUpperCase(); // 대문자 변환
        }
    }
}
