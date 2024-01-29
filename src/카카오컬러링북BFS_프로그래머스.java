import java.util.*;

public class 카카오컬러링북BFS_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6, 4,
                new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    static class Solution {
        static int N, M, count; // 크기, 개수
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};
        static int[][] map; // 입력배열
        static boolean[][] visited; // 방문배열

        public static void init(int m, int n, int[][] picture) {    // 초기화

            N = m;  // 행
            M = n;  // 열
            count = 0;  // 영역 개수

            map = picture;  // 입력배열
            visited = new boolean[N][M];    // 방문배열
        }

        public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
            return (x < 0 || x >= N || y < 0 || y >= M);
        }

        public static void BFS(int x, int y) {  // BFS

            Queue<int[]> queue = new LinkedList<>();    // 큐

            queue.offer(new int[]{x, y});   // 시작점 큐에 삽입
            visited[x][y] = true;   // 시작점 방문
            count++;    // 영역 개수 카운트

            int nowArea = map[x][y];    // 현재 영역 색깔

            while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표
                for (int i = 0; i < 4; i++) {    // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                        continue;

                    if (map[tmpX][tmpY] == nowArea) {    // 현재 영역 색깔과 같으면
                        visited[tmpX][tmpY] = true; // 방문
                        count++;    // 개수 카운트
                        queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                    }
                }
            }
        }

        public static int[] findArea() {    // 영역 개수와 최대 영역 크기 찾기

            int maxSizeOfOneArea = 0, numberOfArea = 0; // 최대 영역 크기, 영역 개수

            for (int i = 0; i < N; i++) {    // 행
                for (int j = 0; j < M; j++) {    // 열
                    if (map[i][j] != 0 && !visited[i][j]) {  // 색이 있고 방문한 적이 없으면
                        BFS(i, j);  // BFS
                        numberOfArea++; // 영역 개수 카운트
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);   // 최대 영역 크기
                        count = 0;  // 크기 초기화
                    }
                }
            }

            return new int[]{numberOfArea, maxSizeOfOneArea};   // 결과배열 리턴
        }

        public int[] solution(int m, int n, int[][] picture) {

            init(m, n, picture);    // 초기화

            int[] answer = findArea();  // 영역 개수, 최대 영역 크기 찾기

            return answer;  // 결과배열 리턴
        }
    }
}
