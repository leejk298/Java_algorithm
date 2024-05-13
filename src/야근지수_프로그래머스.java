import java.util.*;

public class 야근지수_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[]{4, 3, 3}));
    }

    static class Solution {
        public long solution(int n, int[] works) {

            // 큰 값 우선 줄이기위해 => 최대힙 구현
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int w : works)
                pq.offer(w);    // 우선순위 큐에 삽입

            for (int i = 0; i < n; i++) {    // 크기만큼
                int now = pq.poll();    // 하나 꺼내어

                if (now > 1)
                    pq.offer(now - 1);  // 하나 줄이고 다시 삽입 => 크기 비교
            }

            long answer = 0;

            while (!pq.isEmpty()) {  // 비어있지않으면
                int num = pq.poll();    // 하나 꺼내어

                answer += (long) Math.pow(num, 2);   // 제곱
            }

            return answer;
        }
    }
}
