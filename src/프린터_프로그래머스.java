import java.util.*;

public class 프린터_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {2, 1, 3, 2}, 2));
    }

    static class Solution {
        public int solution(int[] priorities, int location) {
            int answer = 1;
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });

            for(int i = 0; i < priorities.length; i++)
                queue.offer(new int[] {i, priorities[i]});

            while(!queue.isEmpty()) {

                for(int i = 0; i < priorities.length; i++) {
                    int[] arr = queue.peek();

                    if(arr[1] == priorities[i]) {
                        if(location == i)
                            return answer;

                        answer++;

                        queue.poll();
                    }
                }
            }

            return answer;
        }
    }
}
