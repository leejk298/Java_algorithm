import java.util.*;

public class 올바른괄호_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("(())()"));
    }

    static class Solution {
        boolean solution(String s) {

            Stack<Character> stack = new Stack<>(); // 스택

            for(char ch : s.toCharArray()) {    // 문자열 순회
                if(ch == '(') { // 여는 괄호이면
                    stack.push('(');    // push
                } else {    // 닫는 괄호이면
                    if(stack.isEmpty()) // 비어있으면
                        return false;   // false
                    // 비어있지 않으면
                    stack.pop();  // pop
                }
            }

            if(!stack.isEmpty())    // 스택이 비어있지 않으면
                return false;   // false
            // 비어있으면
            return true;    // true
        }
    }
}
