import java.util.*;

public class 디스크컨트롤러_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 3}, {1, 9}, {2, 6}}));
    }

    static class Solution {
        public int solution(int[][] jobs) {

            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);   // 요청시간 오름차순
            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);  // 소요시간 오름차순

            int len = jobs.length;  // 길이
            int index = 0, count = 0, end = 0, sum = 0; // 초기화

            while (count < len) {    // 길이만큼
                while (index < len && jobs[index][0] <= end)     // 유효하면
                    pq.offer(jobs[index++]);

                if (pq.isEmpty())    // 비어있으면
                    end = jobs[index][0];   // 해당 작업 요청시간
                else {  // 비어있지않으면
                    int[] now = pq.poll();  // 하나 꺼내어 -> minHeap (소요시간)

                    sum += now[1] + end - now[0];   // 총 시간 갱신
                    end += now[1];  // 종료시간
                    count++;    // 횟수
                }
            }

            return sum / len;
        }
    }
}
