import java.util.*;
import java.io.*;

/*
5
RRRBB
GGBBB
BBBRR
BBRRR
RRRRR
 */

public class 적록색약_백준 {
    static int N;   // 크기
    static char[][] map;    // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        map = new char[N][N];   // 초기화

        for (int i = 0; i < N; i++) {   // 행
            char[] ch = bf.readLine().toCharArray(); // 문자 배열

            for (int j = 0; j < N; j++) {   // 열
                map[i][j] = ch[j];  // 맵 저장
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS(int x, int y, boolean flag) {    // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 시작점 추가
        visited[x][y] = true;   // 방문여부 갱신

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            char nowC = map[nowX][nowY];    // 현재 색상
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(flag) {  // 적록생맹이 아닌경우
                    if (nowC == map[tmpX][tmpY]) {  // 같은 색상이면
                        visited[tmpX][tmpY] = true; // 방문여부 갱신
                        queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                    }
                } else {    // 적록생맹인 경우
                    if (nowC == map[tmpX][tmpY] || (nowC == 'R' && map[tmpX][tmpY] == 'G') ||
                            (nowC == 'G' && map[tmpX][tmpY] == 'R')) {  // R - G 또는 G - R
                        visited[tmpX][tmpY] = true;
                        queue.offer(new int[]{tmpX, tmpY});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        int num1 = 0;
        visited = new boolean[N][N]; // 방문배열 초기화
        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < N; j++) {    // 열
                if(map[i][j] == 'R' && !visited[i][j]) {    // R
                    BFS(i, j, true);
                    num1++;
                }

                if(map[i][j] == 'G' && !visited[i][j]) {    // G
                    BFS(i, j, true);
                    num1++;
                }

                if(map[i][j] == 'B' && !visited[i][j]) {    // B
                    BFS(i, j, true);
                    num1++;
                }
            }
        }

        int num2 = 0;
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if((map[i][j] == 'R' || map[i][j] == 'G') && !visited[i][j]) {  // R 혹은 G
                    BFS(i, j, false);
                    num2++;
                }

                if(map[i][j] == 'B' && !visited[i][j]) {    // B
                    BFS(i, j, false);
                    num2++;
                }
            }
        }

        System.out.print(num1 + " " + num2);    // 개수 출력
    }
}
