import java.util.*;

public class 거리맵최단거리_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][] {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    static class Solution {
        static int[][] visited; // 방문배열
        static int[] dx = {0, 0, 1, -1};    // 4방향
        static int[] dy = {1, -1, 0, 0};

        public int solution(int[][] maps) {

            visited = new int[maps.length][maps[0].length]; // 초기화

            BFS(0, 0, maps); // BFS

            if(visited[maps.length - 1][maps[0].length - 1] == 0)   // 도달 불가능하면 -1
                return -1;

            return visited[maps.length - 1][maps[0].length - 1];    // 도달 가능
        }

        static void BFS(int i, int j, int[][] m) {  // BFS

            visited[i][j] = 1;  // 방문여부 갱신
            Queue<int[]> queue = new LinkedList<>();    // 큐 구현
            queue.add(new int[]{i, j}); // 시작점 삽입

            while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어
                int x = now[0]; // 현재 좌표
                int y = now[1];

                for(int k = 0; k < 4; k++) {    // 4방향
                    int tmpX = x + dx[k];   // 다음 좌표
                    int tmpY = y + dy[k];

                    // 유효한 좌표이면
                    if(tmpX >= 0 && tmpX < m.length && tmpY >= 0 && tmpY < m[0].length) {
                        if(visited[tmpX][tmpY] == 0 && m[tmpX][tmpY] == 1) {    // 방문 가능하면
                            visited[tmpX][tmpY] = visited[x][y] + 1;    // 방문, 거리 갱신
                            queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                        }
                    }
                }
            }
        }
    }
}
