import java.util.*;

public class 숫자게임_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {5, 1, 3, 7},
                new int[] {2, 2, 6, 8}));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            PriorityQueue<Integer> aQueue = new PriorityQueue<>(Collections.reverseOrder());    // 우선 순위 큐
            PriorityQueue<Integer> bQueue = new PriorityQueue<>(Collections.reverseOrder());    // 내림차순 정렬

            for(int i = 0; i < A.length; i++) {
                aQueue.offer(A[i]); // 삽입
                bQueue.offer(B[i]);
            }

            while(!aQueue.isEmpty()) {
                int aNum = aQueue.poll();   // A는 꺼내고
                int bNum = bQueue.peek();   // B는 보기만

                if(aNum < bNum) {   // B가 이기면
                    answer++;
                    bQueue.poll();  // 꺼냄
                }
            }

            return answer;
        }
    }
}
