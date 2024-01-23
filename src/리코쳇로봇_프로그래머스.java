import java.util.*;

public class 리코쳇로봇_프로그래머스 {
    static class Solution {
        static int N, M;    // 크기
        static Pos start, end;  // 출발, 도착점
        static char[][] map;    // 입력배열
        static boolean[][] visited; // 방문배열
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};

        static class Pos {  // 내부 클래스
            int x, y, z;    // 좌표, 비용

            public Pos(int x, int y, int z) {   // 파라미터 생성자
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }

        public static void init(String[] board) {   // 초기화

            N = board.length;   // 행
            M = board[0].length();  // 열

            // 초기화
            map = new char[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < N; i++) {   // 행
                for (int j = 0; j < M; j++) {   // 열
                    map[i][j] = board[i].charAt(j); // 입력배열 저장

                    if (map[i][j] == 'R')   // 출발
                        start = new Pos(i, j, 0);

                    if (map[i][j] == 'G')   // 도착
                        end = new Pos(i, j, 0);
                }
            }
        }

        public static Pos getPos(int dir, Pos now) {    // 다음 좌표 가져오기

            int nowX = now.x, nowY = now.y, nowZ = now.z;   // 현재 좌표
            int tmpX = dx[dir], tmpY = dy[dir]; // 더할 값

            // DFS: 벽과 장애물에 안부딪히면 계속해서 이동
            while (nowX + tmpX >= 0 && nowX + tmpX < N && nowY + tmpY >= 0 && nowY + tmpY < M && map[nowX + tmpX][nowY + tmpY] != 'D') {
                nowX += tmpX;   // 해당 방향으로 계속 이동
                nowY += tmpY;
            }

            return new Pos(nowX, nowY, nowZ + 1);   // 다음 좌표 리턴
        }

        public static int BFS() {   // BFS

            Queue<Pos> queue = new LinkedList<>();  // 큐

            queue.offer(start); // 큐에 시작점 삽입
            visited[start.x][start.y] = true;   // 시작점 방문

            while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
                Pos now = queue.poll(); // 하나 꺼내어

                int nowX = now.x, nowY = now.y, nowZ = now.z;  // 현재 좌표

                if (nowX == end.x && nowY == end.y) // 도착점에 도달하면
                    return nowZ;    // 비용 리턴

                for (int i = 0; i < 4; i++) {   // 4방향
                    Pos next = getPos(i, now);  // 다음 좌표 가져오기

                    if (!visited[next.x][next.y]) { // 방문한 적이 없으면
                        visited[next.x][next.y] = true; // 방문
                        queue.offer(next);  // 큐에 삽입
                    }
                }
            }

            return -1;  // 여기로 오면 도착점에 도달하지 못한 것이므로 -1 리턴
        }

        public int solution(String[] board) {

            init(board);    // 초기화

            return BFS();   // 최소 비용 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}));
    }
}
