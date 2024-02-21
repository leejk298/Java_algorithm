import java.util.*;

public class 숫자게임_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{5, 1, 3, 7},
                new int[]{2, 2, 6, 8}));
    }

    static class Solution {
        public int solution(int[] A, int[] B) {

            PriorityQueue<Integer> aQueue = new PriorityQueue<>(Collections.reverseOrder());    // 우선순위 큐
            PriorityQueue<Integer> bQueue = new PriorityQueue<>(Collections.reverseOrder());    // 내림차순 정렬

            for (int i = 0; i < A.length; i++) { // 길이만큼
                aQueue.offer(A[i]); // 삽입
                bQueue.offer(B[i]);
            }

            int answer = 0; // 결과값

            while (!aQueue.isEmpty()) {  // 기준인 A가 비어있지 않으면
                int numA = aQueue.poll();   // A는 꺼내고
                int numB = bQueue.peek();   // B는 보기만

                if (numA < numB) {   // B가 이기면
                    answer++;   // 개수 카운트
                    bQueue.poll();  // B도 꺼냄
                }
            }

            return answer;
        }
    }
}
