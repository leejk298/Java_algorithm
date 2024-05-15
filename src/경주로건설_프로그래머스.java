import java.util.*;

public class 경주로건설_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }

    static class Solution {
        static int N, cost; // 크기, 총 비용
        static int[][] map; // 최소비용
        static boolean[][][] visited;   // 방문배열, 방향 고려
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};

        static class Node { // 내부 클래스
            int x, y, dir, c;   // 멤버변수

            public Node(int x, int y, int dir, int c) { // 파라미터 생성자
                this.x = x; // 좌표
                this.y = y;
                this.dir = dir; // 방향
                this.c = c; // 비용
            }
        }

        public static void init(int[][] board) {   // 초기화

            N = board.length;  // 배열 크기
            cost = Integer.MAX_VALUE;   // 최대값으로 설정

            map = board;    // 최소비용배열
            visited = new boolean[N][N][4]; // 방문배열
        }

        public static void BFS(int x, int y, int dir, int c) {  // BFS

            Queue<Node> queue = new LinkedList<>(); // 큐

            queue.offer(new Node(x, y, dir, c));    // 시작점 추가 => 시작점은 방향성을 미리 정할 수 없음

            while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
                Node now = queue.poll();    // 하나 꺼내어

                int nowX = now.x, nowY = now.y;   // 현재 좌표
                int nowDir = now.dir;   // 방향
                int nowC = now.c;   // 비용

                if (nowX == N - 1 && nowY == N - 1)  // 끝 점에 도달하면
                    cost = Math.min(cost, nowC);    // 최소 비용

                for (int i = 0; i < 4; i++) {    // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표
                    int tmpDir = i; // 방향 고려
                    int tmpC = nowC;    // 비용

                    if (tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N || map[tmpX][tmpY] == 1)  // 유효하지 않으면
                        continue;

                    if (nowDir == -1)    // 초기
                        tmpC += 100;    // 직선
                    else if (nowDir == tmpDir)   // 방향이 같으면
                        tmpC += 100;    // 직선
                    else    // 다르면
                        tmpC += 600;    // 코너 + 직선

                    if (!visited[tmpX][tmpY][tmpDir] || map[tmpX][tmpY] >= tmpC) {   // 방문하지않았거나, 방문했어도 최소비용이면
                        visited[tmpX][tmpY][tmpDir] = true; // 방문 여부 갱신, 방향성
                        map[tmpX][tmpY] = tmpC; // 최소비용
                        queue.offer(new Node(tmpX, tmpY, tmpDir, tmpC));    // 큐에 삽입
                    }
                }
            }
        }

        public int solution(int[][] board) {

            init(board);    // 초기화

            BFS(0, 0, -1, 0);   // BFS

            return cost;    // 최소비용 출력
        }
    }
}
