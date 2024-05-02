import java.util.*;

public class 무인도_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    static class Solution {
        static int N, M, sum;   // 크기, 결과값
        static char[][] map;    // 입력배열
        static boolean[][] visited; // 방문배열
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};
        static List<Integer> list;  // 결과리슽트

        public static void init(String[] maps) {    // 초기화

            N = maps.length;    // 행
            M = maps[0].length();   // 열
            sum = 0;    // 결과값

            map = new char[N][M];   // 입력배열
            visited = new boolean[N][M];    // 방문배열
            list = new ArrayList<>();   // 결과리스트

            for (int i = 0; i < N; i++) // 크기만큼
                map[i] = maps[i].toCharArray(); // 입력배열 저장
        }

        public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
            return (x < 0 || x >= N || y < 0 || y >= M);
        }

        public static void BFS(int x, int y) {  // BFS

            Queue<int[]> queue = new LinkedList<>();    // 큐

            queue.offer(new int[]{x, y});   // 큐에 시작점 삽입
            visited[x][y] = true;   // 시작점 방문
            sum += map[x][y] - '0';  // 결과값 갱신

            while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표
                for (int i = 0; i < 4; i++) {   // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                        continue;

                    if (map[tmpX][tmpY] != 'X') {   // X가 아니면
                        visited[tmpX][tmpY] = true; // 방문
                        sum += map[tmpX][tmpY] - '0';   // 결과값 갱신
                        queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                    }
                }
            }
        }

        public static void findArea() { // 영역 찾기

            for (int i = 0; i < N; i++) {   // 행
                for (int j = 0; j < M; j++) {   // 열
                    if (!visited[i][j] && map[i][j] != 'X') {   // 방문한 적이 없고 X가 아니면
                        BFS(i, j);  // BFS
                        list.add(sum);  // 리스트에 결과값 삽입
                        sum = 0;    // 결과값 초기화
                    }
                }
            }
        }

        public int[] solution(String[] maps) {

            init(maps); // 초기화

            findArea(); // 영역 찾기

            if (list.size() == 0)   // 영역이 없으면
                return new int[]{-1};   // -1 리턴
            // 영역이 있으면
            Collections.sort(list); // 리스트 정렬

            return list.stream().mapToInt(i -> i).toArray();    // 배열로 리턴
        }
    }
}
