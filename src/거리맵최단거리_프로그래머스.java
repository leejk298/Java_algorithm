import java.util.*;

public class 거리맵최단거리_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    static class Solution {
        static int[][] visited;
        static int[] dx = {0, 0, 1, -1};
        static int[] dy = {1, -1, 0, 0};

        public int solution(int[][] maps) {
            int answer = 0;
            visited = new int[maps.length][maps[0].length];

            BFS(0, 0, maps);

            if(visited[maps.length - 1][maps[0].length - 1] == 0)
                return -1;

            return visited[maps.length - 1][maps[0].length - 1];
        }

        static void BFS(int i, int j, int[][] m) {
            visited[i][j] = 1;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i, j});

            while(!queue.isEmpty()) {
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];

                for(int k = 0; k < 4; k++) {
                    int tmpX = x + dx[k];
                    int tmpY = y + dy[k];

                    if(tmpX >= 0 && tmpX < m.length && tmpY >= 0 && tmpY < m[0].length) {
                        if(visited[tmpX][tmpY] == 0 && m[tmpX][tmpY] == 1) {
                            visited[tmpX][tmpY] = visited[x][y] + 1;
                            queue.offer(new int[] {tmpX, tmpY});
                        }
                    }
                }
            }
        }
    }
}
