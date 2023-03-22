public class 크기가작은부분문자열_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("500220839878"	, "7"));
    }

    static class Solution {
        public int solution(String t, String p) {
            int answer = 0; // 결과
            int lenT = t.length();  // 길이
            int lenP = p.length();
            int len = lenT - lenP;  // 차
            long b = Long.parseLong(p);    // 비교할 숫자

            for(int i = 0; i <= len; i++) { // 차이만큼 비교
                long a = Long.parseLong(t.substring(i, i + lenP)); // 비교할 숫자
                if(a <= b)  // 작거나 같으면
                    answer++;
            }

            return answer;
        }
    }
}
