import java.util.*;

public class 수식최대화_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("100-200*300-500+20"));
    }

    static class Solution {
        private static List<Long> nums = new ArrayList<>(); // 숫자
        private static List<Character> opers = new ArrayList<>();   // 연산자
        private static long answer = 0; // 결과
        public long solution(String expression) {

            char[] operators = {'*', '+', '-'}; // 연산자 초기화
            char[] op = new char[3];    // 우선순위
            boolean[] visited = new boolean[3]; // 중복없는 순열 만들기위해, 방문배열

            stringToNumAndOp(expression);   // 연산자, 피연산자 나누기

            DFS(0, operators, op, visited); // 순열 만들기

            return answer;  // 결과 리턴
        }

        public void stringToNumAndOp(String s) {

            String num = "";    // 문자열

            for(int i = 0; i < s.length(); i++) {   // 길이만큼
                if(s.charAt(i) >= '0' && s.charAt(i) <= '9')   // 숫자
                    num += s.charAt(i); // 문자열 붙이기
                else {  // 연산자
                    nums.add(Long.parseLong(num));  // 숫자로 이뤄진 문자열 Long형으로 바꿔서 리스트에 추가
                    opers.add(s.charAt(i)); // 연산자 리스트에 추가
                    num = "";   // 숫자 문자열 초기화
                }
            }

            nums.add(Long.parseLong(num));  // 나머지 문자열도 숫자이므로 추가
        }

        public void DFS(int depth, char[] operators, char[] op, boolean[] visited) {
            // 베이스케이스
            if(depth == 3)  // 순서가 정해지면
                calcString(op); // 문자열 계산

            // 재귀케이스
            for(int i = 0; i < 3; i++) {    // 3만큼
                if(!visited[i]) {   // 방문하지않았으면
                    visited[i] = true;  // 방문
                    op[depth] = operators[i];   // 해당 연산자 순열에 추가

                    DFS(depth + 1, operators, op, visited); // 재귀콜, 중복 x

                    visited[i] = false; // 리턴 후 해당 연산자 방문여부 초기화
                }
            }
        }

        public void calcString(char[] op) {

            List<Long> tmpNums = new ArrayList<>(nums);     // 임시 리스트, 계산을 위해
            List<Character> tmpOpers = new ArrayList<>(opers);  // 연산자

            for(int i = 0; i < 3; i ++) {   // +, -, *
                for(int j = 0; j < tmpOpers.size(); j++) {  // 연산자 개수
                    if(tmpOpers.get(j) == op[i]) {  // 해당 연산자 찾으면
                        long result = calcNum(tmpNums.remove(j), tmpNums.remove(j), tmpOpers.remove(j));    // 숫자 계산, 연산자 앞, 뒤로 숫자가 오므로
                        tmpNums.add(j--, result);   // 연산자 순서 맞추기위해, for - j
                    }
                }
            }

            answer = Math.max(answer, Math.abs(tmpNums.get(0)));    // 하나의 연산이 끝나면 최대값 저장 후 매번 비교
        }

        public long calcNum(long a, long b, char c) {   // 숫자 계산

            switch(c) { // 문자
                case '+' :
                    return a + b;
                case '-' :
                    return a - b;
                default :
                    return a * b;
            }
        }
    }
}
