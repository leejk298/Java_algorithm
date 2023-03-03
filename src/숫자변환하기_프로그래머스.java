import java.util.*;

public class 숫자변환하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 40, 5));
    }

    static class Solution {
        public static Queue<Integer> queue = new LinkedList<>();
        public static Set<Integer> set = new HashSet<>();

        public int solution(int x, int y, int n) {
            int answer = 0;

            queue.offer(x);

            while(!queue.isEmpty()) {
                int size = queue.size();

                for(int i = 0; i < size; i++) {
                    if(queue.peek() == y)
                        return answer;

                    conversion(queue.poll(), y, n);
                }

                answer++;
            }

            return -1;
        }

        public static void conversion(int x, int y, int n) {
            if(x + n <= y) {
                set.add(x + n);
                queue.offer(x + n);
            }

            if(x * 2 <= y) {
                set.add(x * 2);
                queue.offer(x * 2);
            }

            if(x * 3 <= y) {
                set.add(x * 3);
                queue.offer(x * 3);
            }
        }
    }
}
