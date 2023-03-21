import java.util.*;

public class 문자열정렬_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("Python"));
    }

    static class Solution {
        public String solution(String my_string) {
            my_string = my_string.toLowerCase();
            char[] tmp = my_string.toCharArray();

            Arrays.sort(tmp);

            String answer = new String(tmp);

            return answer;
        }
    }
}
