import java.util.*;

public class 게임맵최단거리_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}}));
    }

    static class Solution {
        static int[][] visited; // 방문 배열, 정수형: 거리 구하기위해
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};

        public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
            return (x < 0 || x >= visited.length || y < 0 || y >= visited[0].length);
        }

        public static void BFS(int x, int y, int[][] maps) {    // BFS

            visited = new int[maps.length][maps[0].length]; // 방문배열 선언
            Queue<int[]> queue = new LinkedList<>();    // 큐

            visited[x][y] = 1;  // 시작점, 거리 1부터 시작
            queue.offer(new int[]{x, y});  // 시작점 큐에 삽입

            while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표
                for (int i = 0; i < 4; i++) {    // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY] != 0)   // 유효한지: 범위에 벗어나거나 방문한 적이 있으면
                        continue;   // 건너뛰기

                    if (maps[tmpX][tmpY] == 1) { // 갈 수 있는 길이면
                        visited[tmpX][tmpY] = visited[nowX][nowY] + 1;  // 방문 여부 갱신, 거리 + 1
                        queue.offer(new int[]{tmpX, tmpY});    // 큐에 삽입
                    }
                }
            }
        }

        public int solution(int[][] maps) {

            BFS(0, 0, maps);    // BFS, (0, 0)부터 시작

            if (visited[maps.length - 1][maps[0].length - 1] == 0)   // 가장 끝 점이 0이면, 도달하지 못한 것이므로
                return -1;  // -1 출력

            return visited[maps.length - 1][maps[0].length - 1];    // 도달했으면, 총 거리 출력
        }
    }
}
