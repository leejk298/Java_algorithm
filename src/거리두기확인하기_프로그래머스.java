import java.util.*;

public class 거리두기확인하기_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new String[][]
                {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }

    static class Solution {
        static int[] dx = {-1, 1, 0, 0};    // 상하좌우
        static int[] dy = {0, 0, -1, 1};

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];  // 결과배열

            for(int i = 0; i < places.length; i++)
                answer[i] = checkDistance(places[i]);   // 대기실 하나씩

            return answer;
        }

        public int checkDistance(String[] s) {

            for(int i = 0; i < s.length; i++)  // 행
                for(int j = 0; j < s[i].length(); j++)  // 열
                    if(s[i].charAt(j) == 'P')  // 'P'이면
                        if(!BFS(i, j, s))   // BFS 수행 후 거짓이면 0
                            return 0;
            // 전부 참이면 1
            return 1;
        }

        public boolean BFS(int x, int y, String[] s) { // BFS
            Queue<int[]> queue = new LinkedList<>();    // 큐
            boolean[][] visited = new boolean[s.length][s.length];  // 방문배열

            queue.offer(new int[] {x, y});  // 초기 좌표값
            visited[x][y] = true;   // 방문여부 갱신

            while(!queue.isEmpty()) {   // 비어있지않으면
                int[] now = queue.poll();   // 하나 꺼내어

                for(int i = 0; i < 4; i++) {    // 4방향
                    int tmpX = now[0] + dx[i];  // 좌표값 x, y
                    int tmpY = now[1] + dy[i];

                    int d = Math.abs(tmpX - x) + Math.abs(tmpY - y);    // 맨허튼 거리값
                    if(tmpX < 0 || tmpY < 0 || tmpX >= s.length || tmpY >= s.length || visited[tmpX][tmpY] || d > 2)    // 유효하지않은 좌표거나 방문했거나 맨허튼 거리값이 초과하면
                        continue;   // 건너뜀

                    visited[tmpX][tmpY] = true; // 방문여부 갱신

                    if(s[tmpX].charAt(tmpY) == 'P') // 'P'이면 거리두기 false
                        return false;
                    else if(s[tmpX].charAt(tmpY) == 'O')    // 'O'이면 큐에 삽입
                        queue.offer(new int[] {tmpX, tmpY});
                }
            }

            return true;    // 전부 다 수행하면 true 리턴
        }
    }
}
