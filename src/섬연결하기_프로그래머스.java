import java.util.*;

public class 섬연결하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[][]{{0, 1, 1},
                {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    static class Solution {
        static int[] parent;    // 대표노드, 부모배열

        public static void init(int n, int[][] costs) { // 초기화

            parent = new int[n];    // 초기화

            for (int i = 0; i < n; i++) // 개수만큼
                parent[i] = i;  // 대표노드 설정

            Arrays.sort(costs, (o1, o2) -> (o1[2] - o2[2]));    // 가중치 오름차순 정렬
        }

        public static int find(int a) { // find

            if (a == parent[a]) // 대표노드와 같으면 == 초기화 상태이면
                return a;   // 그대로 리턴

            return parent[a] = find(parent[a]); // 다르면 대표노드 값 고친 후 리턴
        }

        public static void union(int a, int b) {    // 합집합

            a = find(a);    // a의 대표노드
            b = find(b);    // b의 대표노드

            if (a != b) // 다르면
                parent[b] = a;  // 갱신
        }

        public static int Kruskal(int[][] costs) {  // 크루스칼 알고리즘

            int answer = 0; // 결과값

            for (int i = 0; i < costs.length; i++) {    // 입력배열 길이만큼
                if (find(costs[i][0]) != find(costs[i][1])) {   // 서로 대표노드가 다르면
                    answer += costs[i][2];  // 가중치 합
                    union(costs[i][0], costs[i][1]);    // 합집합
                }
            }

            return answer;  // 결과값 리턴
        }

        public int solution(int n, int[][] costs) {

            init(n, costs); // 초기화

            return Kruskal(costs); // 크루스칼: MST 알고리즘
        }
    }
}
