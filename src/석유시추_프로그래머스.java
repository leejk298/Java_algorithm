import java.util.*;

public class 석유시추_프로그래머스 {
    static class Solution {
        static int N, M, size;  // 크기
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};
        static int[][] map, id; // 입력배열, 석유섬 id
        static boolean[][] visited; // 방문배열

        public static void init(int[][] land) { // 초기화

            N = land.length;    // 행
            M = land[0].length; // 열
            size = 0;   // 섬 크기

            map = land; // 입력배열
            id = new int[N][M]; // id
            visited = new boolean[N][M];    // 방문배열
        }

        public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
            return (x < 0 || x >= N || y < 0 || y >= M);
        }

        public static void BFS(int x, int y, int oilId) {   // BFS

            Queue<int[]> queue = new LinkedList<>();    // 큐

            queue.offer(new int[]{x, y});   // 큐에 시작점 추가
            visited[x][y] = true;   // 시작점 방문
            id[x][y] = oilId;   // 섬 id 저장
            size++; // 섬 크기

            while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표
                for (int i = 0; i < 4; i++) {   // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                        continue;

                    if (map[tmpX][tmpY] == 1) { // 석유가 있으면
                        visited[tmpX][tmpY] = true; // 방문
                        id[tmpX][tmpY] = oilId; // id 저장
                        queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                        size++; // 크기 증가
                    }
                }
            }
        }

        public int solution(int[][] land) {

            init(land); // 초기화

            int oilId = 0;  // 섬 id
            Map<Integer, Integer> hashMap = new HashMap<>();    // 섬, <id, size>

            // 1. 모든 칸에 대한 크기와 id 지정 => BFS
            for (int i = 0; i < N; i++) {   // 행
                for (int j = 0; j < M; j++) {   // 열
                    if (map[i][j] == 1 && !visited[i][j]) { // 석유가 있고 방문한 적이 없으면
                        BFS(i, j, oilId);   // BFS

                        hashMap.put(oilId, size);   // 섬 만들기

                        size = 0;   // 초기화
                        oilId++;    // id 증가
                    }
                }
            }

            int[] oilSum = new int[M];  // 각 열에 해당하는 석유량

            for (int j = 0; j < M; j++) {   // 열
                Set<Integer> hashSet = new HashSet<>(); // 섬 id 집합

                for (int i = 0; i < N; i++) // 행
                    if (map[i][j] == 1) // 석유가 있으면
                        hashSet.add(id[i][j]);  // 해당하는 id를 집합에 저장, 중복제거

                for (int index : hashSet)   // 하나의 열이 끝날 때마다 해당 열에 해당하는 집합을 순회하여
                    oilSum[j] += hashMap.get(index);    // 속해있는 id로 섬 크기를 더하여 석유량을 저장
            }

            int answer = 0; // 결과값

            for (int i = 0; i < M; i++) // 열만큼
                answer = Math.max(answer, oilSum[i]);   // 최대값

            return answer;  // 최대값 리턴
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]
                {{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
    }
}
