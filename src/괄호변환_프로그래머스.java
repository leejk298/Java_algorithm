import java.util.*;

public class 괄호변환_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("()))((()"));
    }

    static class Solution {
        public static boolean check(String s) { // 괄호 개수

            Stack<Character> stack = new Stack<>(); // 스택

            for(char c : s.toCharArray()) { // 문자열 순회
                if(c == '(')    // 여는 괄호이면
                    stack.push(c);  // push
                else {  // 아니면
                    if(stack.isEmpty()) // 스택이 비어있으면
                        return false;   // false
                    else    // 아니면
                        stack.pop();    // pop
                }
            }

            return stack.isEmpty(); // 스택이 비었는 지 유무를 리턴
        }

        public static String DFS(String s) {    // DFS

            int count = 0;  // 개수
            String result = ""; // 결과 문자열

            if(s.equals(""))    // 공백이면
                return s;   // 그대로 리턴

            int index = 0;  // 인덱스
            while(index < s.length()) { // 문자열 길이만큼
                char c = s.charAt(index++); // 해당 문자

                if(c == '(')    // 여는 괄호이면
                    count++;    // 개수 카운트
                else
                    count--;

                if(count == 0)  // 0이면
                    break;  // while 종료
            }

            String u = s.substring(0, index);   // 문자열1
            String v = s.substring(index, s.length());  // 문자열2

            if(check(u))   // 개수가 맞으면
                result = u + DFS(v);
            else {  // 아니면
                result = "(" + DFS(v) + ")";    // 괄호 추가

                for(int j = 1; j < u.length() - 1; j++) {   // 문자열1 길이만큼
                    char c = u.charAt(j);   // 해당 문자

                    if(c == '(')    // 여는 괄호이면
                        result += ')';  // 닫는 괄호 추가
                    else
                        result += '(';
                }
            }

            return result;  // 결과 문자열 리턴
        }

        public String solution(String p) {

            if(check(p))    // 올바른 괄호
                return p;

            return DFS(p);  // 균형잡힌 괄호
        }
    }
}
