import java.util.*;

public class 석유시추_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]
                {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
    }

    static class Solution {
        static int N, M, count; // 행, 열, 섬 크기
        static int[][] map, id; // 입력, 섬이름 배열
        static boolean[][] visited; // 방문배열
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};

        public static void init(int[][] land) { // 초기화

            N = land.length;    // 행
            M = land[0].length; // 열
            count = 0;  // 섬 크기

            map = land; // 입력배열
            id = new int[N][M]; // 섬 이름 배열
            visited = new boolean[N][M];    // 방문배열
        }

        public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
            return (x < 0 || x >= N || y < 0 || y >= M);
        }

        public static void BFS(int x, int y, int oilId) {   // BFS

            Queue<int[]> queue = new LinkedList<>();    // 큐

            queue.offer(new int[]{x, y});   // 큐에 시작점 삽입
            visited[x][y] = true;   // 방문
            id[x][y] = oilId;   // 섬 이름 저장
            count++;    // 섬 크기 카운트

            while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표

                for (int i = 0; i < 4; i++) {   // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                        continue;

                    if (map[tmpX][tmpY] == 1) { // 석유가 있으면
                        visited[tmpX][tmpY] = true; // 방문
                        id[tmpX][tmpY] = oilId; // 섬 이름 저장
                        count++;    // 개수 카운트
                        queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                    }
                }
            }
        }

        public static int printMaxCount() { // 최대값 출력

            Map<Integer, Integer> hashMap = new HashMap<>();    // 집합
            int index = 0;  // 섬 이름

            for (int i = 0; i < N; i++) {   // 행
                for (int j = 0; j < M; j++) {   // 열
                    if (!visited[i][j] && map[i][j] == 1) { // 방문한 적이 없고 석유가 있으면
                        BFS(i, j, index);   // BFS

                        hashMap.put(index, count);  // 섬 이름, 섬 크기로 저장

                        count = 0;  // 크기 초기화
                        index++;    // 이름 카운트
                    }
                }
            }

            int[] arr = new int[M]; // 석유값 배열

            for (int j = 0; j < M; j++) {   // 열
                Set<Integer> hashSet = new HashSet<>(); // 집합

                for (int i = 0; i < N; i++) // 행
                    if (map[i][j] == 1) // 석유가 있으면
                        hashSet.add(id[i][j]);  // 섬 이름 추가

                for (int key : hashSet) // 각 열에 있는 섬 이름 순회
                    arr[j] += hashMap.get(key); // 배열값 저장
            }

            int answer = 0; // 결과값

            for (int i = 0; i < M; i++) // 열
                answer = Math.max(answer, arr[i]);  // 최대값 갱신

            return answer;  // 결과값 리턴
        }

        public int solution(int[][] land) {

            init(land); // 초기화

            return printMaxCount(); // 최대 석유값 리턴
        }
    }
}
