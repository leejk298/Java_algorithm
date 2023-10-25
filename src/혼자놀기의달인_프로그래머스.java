import java.util.*;

public class 혼자놀기의달인_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[] {8, 6, 3, 7, 2, 5, 1, 4}));
    }

    static class Solution {
        static boolean[] visited;   // 방문배열
        static int depth;   // 깊이

        public static void DFS(int v, int[] cards) {   // DFS

            if(!visited[v]) {   // 방문한 적이 없으면
                visited[v] = true;  // 방문
                depth += 1; // 깊이 + 1

                DFS(cards[v - 1], cards);   // DFS, 재귀콜
            }
        }

        public int solution(int[] cards) {

            int answer = 0; // 결과값
            int len = cards.length; // 길이

            // 초기화
            List<Integer> list = new ArrayList<>();
            visited = new boolean[len + 1];

            for(int i = 1; i <= len; i++) { // 길이만큼
                if(!visited[i]) {   // 방문한 적이 없으면
                    visited[i] = true;  // 방문
                    depth = 1;  // 깊이 1
                    DFS(cards[i - 1], cards);   // DFS
                    list.add(depth);    // 리스트에 추가
                }
            }

            if(list.size() < 2) // 2보다 작으면
                return 0;   // 0 리턴

            Collections.sort(list, Collections.reverseOrder()); // 리스트 내림차순 정렬
            answer = list.get(0) * list.get(1); // 결과값

            return answer;  // 리턴
        }
    }
}
