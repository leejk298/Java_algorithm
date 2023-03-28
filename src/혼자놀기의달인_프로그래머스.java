import java.util.*;

public class 혼자놀기의달인_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {8, 6, 3, 7, 2, 5, 1, 4}));
    }

    static class Solution {
        static boolean[] visited;
        static int depth;

        public int solution(int[] cards) {
            int answer = 0;
            int len = cards.length;

            List<Integer> list = new ArrayList<>();
            visited = new boolean[len + 1];

            for(int i = 1; i <= len; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    depth = 1;

                    DFS(cards[i - 1], cards);

                    list.add(depth);
                }
            }

            if(list.size() < 2)
                return 0;

            Collections.sort(list, Collections.reverseOrder());

            answer = list.get(0) * list.get(1);
            return answer;
        }

        static void DFS(int v, int[] cards) {
            if(!visited[v]) {
                visited[v] = true;
                depth += 1;

                DFS(cards[v - 1], cards);
            }
        }
    }
}
