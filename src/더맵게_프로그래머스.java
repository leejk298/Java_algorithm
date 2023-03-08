import java.util.*;

public class 더맵게_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {1, 2, 3, 9, 10, 12}, 7));
    }

    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i : scoville)
                pq.offer(i);

            int sum = 0;
            while(pq.peek() < K) {
                if(pq.size() == 1)
                    return -1;

                int min1 = pq.poll();
                int min2 = pq.poll();

                sum = min1 + min2 * 2;
                answer++;

                pq.add(sum);
            }

            return answer;
        }
    }
}
