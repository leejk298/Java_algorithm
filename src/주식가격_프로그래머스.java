import java.util.*;

public class 주식가격_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {1, 2, 3, 2, 3})));
    }

    static class Solution {
        public int[] solution(int[] prices) {
            int len = prices.length;    // 길이
            int[] answer = new int[len];    // 결과배열
            Stack<Integer> stack = new Stack<>();   // 스택 자료구조

            for(int i = 0; i < len; i++) {  // 길이만큼
                // 비어있지않고 top에 있는 값이 더 크면 (하락장)
                while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                    int p = stack.pop();    // 꺼내어
                    answer[p] = i - p;      // 시간 체크
                }

                // 비어있거나 상승장이면
                stack.push(i);   // 삽입
            }

            while(!stack.isEmpty()) {   // 아직 스택에 남아있으면
                int p = stack.pop();    // 꺼내어
                answer[p] = len - 1 - p;  // 시간 체크
            }

            return answer;
        }
    }
}