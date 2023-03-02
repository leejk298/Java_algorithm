import java.util.*;

public class 섬연결하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[][] {{0, 1, 1},
                {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2,3,8}}));
    }

    static class Solution {
        static int[] parent;    // 대표노드

        public int solution(int n, int[][] costs) {
            int answer = 0; // 결과
            int len = costs.length; // 길이

            parent = new int[n];  // 초기화
            for(int i = 0; i < n; i++)
                parent[i] = i;

            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });

            for(int i = 0; i < len; i++) {
                if(find(costs[i][0]) != find(costs[i][1])) {
                    answer += costs[i][2];
                    union(costs[i][0], costs[i][1]);
                }
            }

            return answer;
        }

        private static void union(int a, int b) {   // 합집합
            a = find(a);
            b = find(b);

            if(a != b)
                parent[b] = a;
        }

        private static int find(int a) {    // find
            if(a == parent[a])
                return a;
            // 다르면
            return parent[a] = find(parent[a]); // 대표 노드로 찾기
        }
    }
}
