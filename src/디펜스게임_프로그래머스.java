import java.util.*;

public class 디펜스게임_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(7, 3, new int[] {4, 2, 4, 5, 3, 3, 1}));
    }

    static class Solution {
        public int solution(int n, int k, int[] enemy) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for(int i = 0; i < enemy.length; i++) {
                n -= enemy[i];
                pq.add(enemy[i]);
                answer++;

                if(n < 0) {
                    if(k > 0 && !pq.isEmpty()) {
                        n += pq.poll();
                        k--;
                    } else {
                        answer--;

                        break;
                    }
                }
            }

            return answer;
        }
    }
}
