import java.util.*;

public class 올바른괄호_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(())()"));
    }

    static class Solution {
        boolean solution(String s) {
            Stack<Character> stack = new Stack<>();

            int i = 0;
            while(i < s.length()) {
                if(s.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if(stack.isEmpty())
                        return false;

                    stack.pop();
                }

                i++;
            }

            if(!stack.isEmpty())
                return false;

            return true;
        }
    }
}
