import java.util.*;

public class 이중우선순위큐_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"})));
    }

    static class Solution {
        public int[] solution(String[] operations) {
            int[] answer = new int[2];
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for(String s : operations) {
                StringTokenizer st = new StringTokenizer(s);
                String op = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(op.equals("I")) {
                    minHeap.offer(num);
                    maxHeap.offer(num);

                    continue;
                }

                if(op.equals("D")) {
                    if(minHeap.isEmpty())
                        continue;

                    if(num < 0) {
                        int min = minHeap.poll();
                        maxHeap.remove(min);
                    } else {
                        int max = maxHeap.poll();
                        minHeap.remove(max);
                    }
                }
            }

            if(!minHeap.isEmpty()) {
                answer[0] = maxHeap.poll();
                answer[1] = minHeap.poll();
            }

            return answer;
        }
    }
}
