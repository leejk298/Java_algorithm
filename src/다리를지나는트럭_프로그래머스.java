import java.util.*;

public class 다리를지나는트럭_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(2, 10, new int[]{7, 4, 5, 6}));
    }

    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {

            int answer = 0;
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < bridge_length; i++)
                queue.offer(0); // 0으로 채움

            int i = 0, w = 0;
            while (i < truck_weights.length) {
                w -= queue.poll();  // 처음에는 0을 뺌
                answer++;   // 한칸 이동

                if (w + truck_weights[i] <= weight) {
                    queue.offer(truck_weights[i]);
                    w += truck_weights[i++];
                } else    // 안되면 0 추가
                    queue.offer(0);
            }
            // 마지막 원소가 다리에 들어가면 끝나므로 길이만큼 더 해줌
            return answer + bridge_length;
        }
    }
}
