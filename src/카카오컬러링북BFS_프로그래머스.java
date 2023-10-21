import java.util.*;

public class 카카오컬러링북BFS_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6, 4,
                new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }

    static class Solution {
        static int N, M, numberOfArea, maxSizeOfOneArea;    // 크기
        static int[][] map; // 입력배열
        static boolean[][] visited; // 방문배열
        static int[] dx = {-1, 1, 0, 0};    // 4방향
        static int[] dy = {0, 0, -1, 1};

        public int[] solution(int m, int n, int[][] picture) {
            // 초기화
            numberOfArea = 0;
            maxSizeOfOneArea = 0;
            N = m;
            M = n;

            map = picture;
            visited = new boolean[N][M];
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < N; i++) {    // 행
                for(int j = 0; j < M; j++) {    // 열
                    if(map[i][j] != 0 && !visited[i][j]) {  // 0이 아니면서 방문한 적이 없으면
                        BFS(i, j);  // BFS

                        numberOfArea++; // 영역 개수 카운트
                        list.add(maxSizeOfOneArea); // 리스트에 저장
                        maxSizeOfOneArea = 0;   // 초기화
                    }
                }
            }

            Collections.sort(list, Collections.reverseOrder()); // 내림차순 정렬

            int[] answer = new int[2];  // 결과배열
            answer[0] = numberOfArea;   // 총 영역 개수
            answer[1] = list.get(0);    // 최대 크기

            return answer;  // 결과배열 리턴
        }

        public static void BFS(int x, int y) {  // BFS

            Queue<int[]> queue = new LinkedList<>();    // 큐

            queue.offer(new int[] {x, y});  // 시작점 추가
            visited[x][y] = true;   // 방문
            maxSizeOfOneArea++; // 영역 개수 카운트

            while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
                int[] now = queue.poll();   // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 현재 좌표
                int K = map[nowX][nowY];    // 해당하는 값
                for(int i = 0; i < 4; i++) {    // 4방향
                    int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                    if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= M)  // 유효한지
                        continue;

                    if(map[tmpX][tmpY] == K && !visited[tmpX][tmpY]) {  // 같은 값이면서 방문한 적이 없으면
                        visited[tmpX][tmpY] = true; // 방문
                        maxSizeOfOneArea++; // 개수 카운트
                        queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                    }
                }
            }
        }
    }
}
