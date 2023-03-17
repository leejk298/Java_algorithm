import java.util.*;

public class 짝지어제거하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("baabaa"));
    }

    static class Solution {
        public int solution(String s) {
            char[] ch = s.toCharArray();

            Stack<Character> stack = new Stack<>();

            for(char c : ch) {
                if(!stack.isEmpty() && stack.peek() == c)
                    stack.pop();
                else
                    stack.push(c);
            }

            if(stack.isEmpty())
                return 1;

            return 0;
        }
    }
}
