import java.util.*;

public class 택배상자_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {5, 4, 3, 2, 1}));
    }

    static class Solution {
        public int solution(int[] order) {
            int answer = 0;

            Stack<Integer> stack = new Stack<>();

            int i = 0, j = 1;

            while(true) {
                if(!stack.isEmpty() && order[i] == stack.peek()) {
                    answer++;
                    i++;
                    stack.pop();

                    continue;
                }

                if(j > order.length)
                    break;

                if(order[i] == j) {
                    answer++;
                    i++;
                    j++;

                    continue;
                }

                stack.push(j++);
            }

            return answer;
        }
    }
}
