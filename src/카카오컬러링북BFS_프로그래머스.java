import java.util.*;

public class 카카오컬러링북BFS_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6, 4,
                new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    static class Solution {
        static int N, M, numberOfArea, maxSizeOfOneArea;
        static int[][] map;
        static boolean[][] visited;
        static int[] dx = {-1, 1, 0, 0};
        static int[] dy = {0, 0, -1, 1};

        public int[] solution(int m, int n, int[][] picture) {

            numberOfArea = 0;
            maxSizeOfOneArea = 0;
            N = m;
            M = n;

            map = picture;
            visited = new boolean[N][M];
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(map[i][j] != 0 && !visited[i][j]) {
                        BFS(i, j);

                        numberOfArea++;
                        list.add(maxSizeOfOneArea);
                        maxSizeOfOneArea = 0;
                    }
                }
            }

            Collections.sort(list, Collections.reverseOrder());

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = list.get(0);

            return answer;
        }

        public static void BFS(int x, int y) {

            Queue<int[]> queue = new LinkedList<>();

            queue.offer(new int[] {x, y});
            visited[x][y] = true;
            maxSizeOfOneArea++;

            while(!queue.isEmpty()) {
                int[] now = queue.poll();

                int nowX = now[0], nowY = now[1];
                int K = map[nowX][nowY];
                for(int i = 0; i < 4; i++) {
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];

                    if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M)
                        continue;

                    if(map[tmpX][tmpY] == K && !visited[tmpX][tmpY]) {
                        visited[tmpX][tmpY] = true;
                        maxSizeOfOneArea++;
                        queue.offer(new int[] {tmpX, tmpY});
                    }
                }
            }
        }
    }
}
