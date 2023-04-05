import java.util.*;

public class 미로탈출_프로그래머스 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[] {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}));
    }

    static class Solution {
        static char[][] map;    // 문자배열
        static int[] dx = {-1, 1, 0, 0};    // 상 하 좌 우
        static int[] dy = {0, 0, -1, 1};
        static boolean[][] visited; // 방문배열

        public int solution(String[] maps) {
            int answer = 0; // 결과
            // 초기화
            map = new char[maps.length][maps[0].length()];
            visited = new boolean[maps.length][maps[0].length()];
            Node S = null, L = null, E = null;

            for(int i = 0; i < maps.length; i++) {  // 행
                for(int j = 0; j < maps[i].length(); j++) { // 열
                    if(maps[i].charAt(j) == 'S')    // 시작
                        S = new Node(i, j, 0);
                    if(maps[i].charAt(j) == 'L')    // 레버
                        L = new Node(i, j, 0);
                    if(maps[i].charAt(j) == 'E')    // 끝
                        E = new Node(i, j, 0);

                    map[i][j] = maps[i].charAt(j);  // 저장
                }
            }

            answer += BFS(S.x, S.y, L.x, L.y);    // S -> L, BFS

            if(answer != -1) {  // S -> L로 도달 가능하면
                visited = new boolean[map.length][map[0].length];
                int num = BFS(L.x, L.y, E.x, E.y);    // L -> E, BFS 수행

                if(num == -1)   // L -> E 도달 불가
                    answer = -1;    // -1 리턴
                else    // 도달 가능
                    answer += num;  // 결과 더해줌
            }

            return answer;  // 결과 리턴
        }

        static int BFS(int sX, int sY, int eX, int eY) {    // BFS
            Queue<Node> queue = new LinkedList<>(); // 큐

            queue.offer(new Node(sX, sY, 0)); // 시작점 넣고
            visited[sX][sY] = true;   // 방문여부 갱신

            while(!queue.isEmpty()) {   // 비어있지않으면
                Node now = queue.poll();    // 하나 꺼내어

                int x = now.x;  // 좌표, 거리
                int y = now.y;
                int d = now.d;

                if(x == eX && y == eY)    // 출구에 도달
                    return d;   // 거리 리턴

                for(int i = 0; i < 4; i++) {    // 4방향
                    int tmpX = x + dx[i];
                    int tmpY = y + dy[i];

                    if(tmpX < 0 || tmpY < 0 || tmpX >= map.length || tmpY >= map[0].length)    // 유효하지않으면
                        continue;   // 건너뛰기

                    if(!visited[tmpX][tmpY] && map[tmpX][tmpY] != 'X') {    // 방문하지않았고 갈 수 있는 통로면
                        visited[tmpX][tmpY] = true; // 방문여부 갱신

                        queue.offer(new Node(tmpX, tmpY, d + 1));   // 큐에 삽입, 거리 1 증가
                    }
                }
            }

            return -1;  // 큐가 다 끝나고 여기로 오면 도달 불가이므로 -1 리턴
        }

        static class Node { // Node 클래스
            int x, y, d;    // 좌표, 거리

            Node(int x, int y, int d) { // 생성자
                this.x = x;
                this.y = y;
                this.d = d;
            }
        }
    }
}
