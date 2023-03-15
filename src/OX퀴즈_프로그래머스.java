import java.util.Arrays;

public class OX퀴즈_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"3 - 4 = -3", "5 + 6 = 11"})));
    }

    static class Solution {
        public String[] solution(String[] quiz) {
            int len = quiz.length;
            String[] answer = new String[len];

            for(int i = 0; i < len; i++) {
                String[] str = new String[len];
                str = quiz[i].split(" ");

                if(str[1].equals("-")) {
                    if((Integer.parseInt(str[0]) - Integer.parseInt(str[2])) == Integer.parseInt(str[4]))
                        answer[i] = "O";
                    else
                        answer[i] = "X";
                }

                if(str[1].equals("+")) {
                    if((Integer.parseInt(str[0]) + Integer.parseInt(str[2])) == Integer.parseInt(str[4]))
                        answer[i] = "O";
                    else
                        answer[i] = "X";
                }
            }

            return answer;
        }
    }
}
