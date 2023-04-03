import java.util.*;

public class 괄호변환_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()))((()"));
    }

    static class Solution {
        public String solution(String p) {
            if(check(p))    // 올바른 괄호
                return p;

            return DFS(p);  // 균형잡힌 괄호
        }

        static boolean check(String s) {
            Stack<Character> stack = new Stack<>();

            for(char c : s.toCharArray()) {
                if(c == '(')
                    stack.push(c);
                else {
                    if(stack.isEmpty())
                        return false;
                    else
                        stack.pop();
                }
            }

            return stack.isEmpty();
        }

        static String DFS(String s) {
            int count = 0;
            String result = "";

            if(s.equals(""))
                return s;

            int index = 0;
            while(index < s.length()) {
                char c = s.charAt(index++);

                if(c == '(')
                    count++;
                else
                    count--;

                if(count == 0)
                    break;
            }

            String u = s.substring(0, index);
            String v = s.substring(index, s.length());

            if(check(u))
                result = u + DFS(v);
            else {
                result = "(" + DFS(v) + ")";

                for(int j = 1; j < u.length() - 1; j++) {
                    char c = u.charAt(j);

                    if(c == '(')
                        result += ')';
                    else
                        result += '(';
                }
            }

            return result;
        }
    }
}
