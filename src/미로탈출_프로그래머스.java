import java.util.*;

public class 미로탈출_프로그래머스 {
    static class Solution {
        static int N, M;    // 크기
        static char[][] map;    // 입력배열
        static int[][] D;       // 거리배열
        static boolean[][] visited; // 방문배열
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};
        static int[] S, L, E;   // 좌표

        public static void init(String[] maps) {    // 초기화

            N = maps.length;
            M = maps[0].length();

            map = new char[N][M];
            visited = new boolean[N][M];
            D = new int[N][M];

            for (int i = 0; i < N; i++) {  // 행
                for (int j = 0; j < M; j++) { // 열
                    map[i][j] = maps[i].charAt(j);  // 입력배열 저장

                    if (map[i][j] == 'S')    // 시작 좌표
                        S = new int[]{i, j};
                    if (map[i][j] == 'L')    // 레버
                        L = new int[]{i, j};
                    if (map[i][j] == 'E')    // 도착
                        E = new int[]{i, j};
                }
            }
        }

        public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
            return (x < 0 || x >= N || y < 0 || y >= M);
        }

        public static int BFS(int[] S, int[] E) {   // BFS

            Queue<int[]> queue = new LinkedList<>();    // 큐

            queue.offer(new int[]{S[0], S[1]});    // 큐에 시작점 추가
            visited[S[0]][S[1]] = true; // 방문 여부 갱신
            D[S[0]][S[1]] = 0;  // 거리 0

            while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표
                if (nowX == E[0] && nowY == E[1])    // 도착하면
                    return D[nowX][nowY];   // 거리값 리턴

                for (int i = 0; i < 4; i++) {   // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY))  // 유효한지
                        continue;

                    if (!visited[tmpX][tmpY] && map[tmpX][tmpY] != 'X') {   // 방문하지 않았고 벽이 아니면
                        visited[tmpX][tmpY] = true; // 방문
                        D[tmpX][tmpY] = D[nowX][nowY] + 1;  // 거리값 갱신
                        queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                    }
                }
            }

            return -1;  // 여기 도달하면 도착하지 못한 것이므로 -1 리턴
        }

        public int solution(String[] maps) {

            init(maps); // 초기화

            int answer = BFS(S, L);    // BFS

            if (answer != -1) { // 레버에 도달했으면
                visited = new boolean[N][M];   // 방문배열 초기화, 이전 경로로 돌아가야되는 경우도 있으므로

                int num = BFS(L, E);    // BFS, 도착 좌표까지 비용
                if (num == -1)  // 도달하지 못했으면
                    answer = -1;    // -1
                else    // 도달하면
                    answer += num;  // 총 비용 갱신
            }

            return answer;  // 총 비용 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
    }
}
