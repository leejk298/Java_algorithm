import java.util.*;

public class 프로세스_프로그래머스 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    static class Solution {

        public int solution(int[] priorities, int location) {

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> { // 정렬
                return (o2[1] - o1[1]); // 내림차순
            });

            for (int i = 0; i < priorities.length; i++) // 길이만큼
                pq.offer(new int[]{i, priorities[i]});  // 우선순위 큐 저장

            int answer = 1; // 순위 1부터

            while (!pq.isEmpty()) { // 우선순위 큐가 비어있지 않으면
                for (int i = 0; i < priorities.length; i++) {   // 길이만큼
                    int[] now = pq.peek();  // 하나 꺼내어

                    if (now[1] == priorities[i]) {  // 현재 프로세스가 제일 높으면
                        if (location == i)  // 정해진 순위가 맞으면
                            return answer;  // 결과값 리턴
                        else {  // 아니면
                            answer++;  // 순위 갱신
                            pq.poll();  // 해당 프로세스 제거
                        }
                    }
                }
            }

            return answer;  // 결과 리턴
        }
    }
}
