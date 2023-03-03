import java.util.*;

public class 가장먼노드_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(6, new int[][] {{3, 6},
                {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }

    static class Solution {
        static List<Integer> arr[];
        static boolean[] visited;
        static int[] D;

        public int solution(int n, int[][] edge) {
            int answer = 0;
            arr = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            D = new int[n + 1];

            for(int i = 1; i <= n; i++)
                arr[i] = new ArrayList<>();

            for(int[] e : edge) {
                arr[e[0]].add(e[1]);
                arr[e[1]].add(e[0]);
            }

            for(int i = 1; i <= n; i++)
                Collections.sort(arr[i]);

            BFS(1);

            Arrays.sort(D);
            int max = D[n];

            for(int i : D)
                if(max == i)
                    answer++;

            return answer;
        }

        static void BFS(int v) {
            Queue<Integer> queue = new LinkedList<>();

            queue.add(v);
            visited[v] = true;
            D[v] = 1;

            while(!queue.isEmpty()) {
                int now = queue.poll();
                for(int i : arr[now]) {
                    if(!visited[i]) {
                        visited[i] = true;
                        D[i] = D[now] + 1;
                        queue.add(i);
                    }
                }
            }
        }
    }
}
