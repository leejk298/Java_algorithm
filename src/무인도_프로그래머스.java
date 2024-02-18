import java.util.*;

public class 무인도_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[]{"X591X", "X1X5X", "X231X", "1XXX1"})));
    }

    static class Solution {
        static char[][] map;    // 입력배열
        static boolean[][] visited; // 방문배열
        static int sum; // 총합
        static List<Integer> list;  // 결과리스트
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};

        public static void init(String[] maps) {    // 초기화

            map = new char[maps.length][maps[0].length()];  // 입력배열
            visited = new boolean[maps.length][maps[0].length()];   // 방문배열
            list = new ArrayList<>();   // 결과리스트
            sum = 0;    // 개수 초기화

            for (int i = 0; i < maps.length; i++)    // 행
                map[i] = maps[i].toCharArray(); // 입력배열 저장
        }

        public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
            return (x < 0 || x >= map.length || y < 0 || y >= map[0].length);
        }

        public static void BFS(int x, int y) {  // BFS

            Queue<int[]> queue = new LinkedList<>();    // 큐

            queue.offer(new int[]{x, y});  // 큐에 시작점 삽입
            visited[x][y] = true;   // 방문 여부 갱신
            sum += map[x][y] - '0'; // 합 갱신

            while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표
                for (int i = 0; i < 4; i++) {    // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    // 유효하지 않거나 방문했거나 바다인 경우, 건너뛰기
                    if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY] || map[tmpX][tmpY] == 'X')
                        continue;

                    sum += map[tmpX][tmpY] - '0';   // 숫자이면 합 갱신
                    visited[tmpX][tmpY] = true; // 방문 여부 갱신
                    queue.offer(new int[]{tmpX, tmpY});    // 큐에 삽입
                }
            }
        }

        public static void findIsland() {   // 섬 찾기

            for (int i = 0; i < map.length; i++) {   // 행
                for (int j = 0; j < map[i].length; j++) {    // 열
                    if (map[i][j] != 'X' && !visited[i][j]) {    // X가 아니면서 방문한 적이 없으면
                        BFS(i, j);  // BFS

                        list.add(sum);  // 연결요소의 총 합 저장
                        sum = 0;    // 합 초기화
                    }
                }
            }
        }

        public static int[] findResult() {  // 결과배열 저장

            if (list.size() > 0) {   // 리스트가 존재하면
                int[] answer = new int[list.size()];    // 결과배열 선언

                for (int i = 0; i < list.size(); i++)    // 크기만큼
                    answer[i] = list.get(i);    // 저장

                Arrays.sort(answer);    // 오름차순 정렬

                return answer;  // 결과배열 리턴
            }

            // 존재하지 않으면
            return new int[]{-1};  // -1 리턴
        }

        public int[] solution(String[] maps) {

            init(maps); // 초기화

            findIsland();   // 섬 찾기

            return findResult();    // 결과배열 리턴
        }
    }
}
