public class 윤년달력_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, 24));
    }

    static class Solution {
        public String solution(int a, int b) {
            String answer = "";
            String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
            int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

            int sumDate = 0;
            for(int i = 0; i < a - 1; i++)
                sumDate += date[i];
            sumDate += b - 1;

            answer = day[sumDate % 7];

            return answer;
        }
    }
}
