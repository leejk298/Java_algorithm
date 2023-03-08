import java.util.*;
public class 기능개발_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[] {93, 30, 55}, new int[] {1, 30, 5})));
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < progresses.length; i++) {
                int num = 100 - progresses[i];
                if(num % speeds[i] == 0)
                    queue.offer(num / speeds[i]);
                else
                    queue.offer(num / speeds[i] + 1);
            }

            List<Integer> arr = new ArrayList<>();

            int now = queue.peek(), count = 0;
            while(!queue.isEmpty()) {
                int next = queue.poll();

                if(now < next) {
                    arr.add(count);
                    count = 0;
                    now = next;
                }

                count++;
            }

            arr.add(count);

            return arr.stream().mapToInt(i -> i).toArray();
        }
    }
}
