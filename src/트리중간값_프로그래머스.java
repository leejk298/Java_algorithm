import java.util.*;

public class 트리중간값_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4, new int[][]{{1, 2}, {2, 3}, {3, 4}}));
    }

    static class Solution {
        public int solution(int n, int[][] edges) {

            ArrayList<Integer> list[] = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++)
                list[i] = new ArrayList<>();

            for(int[] e : edges) {
                list[e[0]].add(e[1]);
                list[e[1]].add(e[0]);
            }

            int s = 1, max = 0, count = 0;
            int[] result = BFS(list, s, n);
            for(int i = 2; i <= n; i++)
                if(result[i] > result[s])
                    s = i;

            result = BFS(list, s, n);
            s = 1;

            for(int i = 2; i <= n; i++)
                if(result[i] > result[s])
                    s = i;

            for(int i : result)
                max = Math.max(max, i);

            for(int i : result)
                if(max == i)
                    count++;

            if(count >= 2)
                return max;

            max = 0;
            count = 0;
            result = BFS(list, s, n);

            for(int i : result)
                max = Math.max(max, i);

            for(int i : result)
                if(max == i)
                    count++;

            if(count >= 2)
                return max;

            return max - 1;
        }

        static int[] BFS(ArrayList<Integer> list[], int s, int n) {

            boolean[] visited = new boolean[n + 1];
            int[] D = new int[n + 1];
            LinkedList<Integer> queue = new LinkedList<>();

            queue.add(s);
            visited[s] = true;

            while(!queue.isEmpty()) {
                int now = queue.poll();

                for(int i : list[now]) {
                    if(!visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                        D[i] = D[now] + 1;
                    }
                }
            }

            return D;
        }
    }
}
