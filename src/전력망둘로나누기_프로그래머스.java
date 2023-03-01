import java.util.*;

public class 전력망둘로나누기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(9, new int[][]{{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
    }

    static class Solution {
        static List<Integer> arr[];

        public int solution(int n, int[][] wires) {
            int answer = n;
            arr = new ArrayList[n + 1];

            for(int i = 1; i <= n; i++)
                arr[i] = new ArrayList<>();

            for(int i = 0; i < wires.length; i++) {
                arr[wires[i][0]].add(wires[i][1]);
                arr[wires[i][1]].add(wires[i][0]);
            }

            for(int i = 0; i < wires.length; i++) {
                int a = BFS(wires[i][0], wires[i][1], n);
                int b = BFS(wires[i][1], wires[i][0], n);

                answer = Math.min(answer, Math.abs(a - b));
            }

            return answer;
        }

        static int BFS(int a, int b, int n) {
            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[n + 1];

            int count = 0;
            queue.add(a);
            visited[a] = true;

            while(!queue.isEmpty()) {
                int now = queue.poll();

                for(int next : arr[now]) {
                    if(!visited[next] && next != b) {
                        visited[next] = true;
                        queue.add(next);
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
