import java.util.*;
import java.io.*;

/*
5
5 6
SOOOOO
XXOXXO
XXXOOO
XXXOXX
XXXOFX
2 3
SOX
XXF
1 3
SXF
2 3
SXX
OFX
2 3
SXX
XFX
*/

public class 코테복기3 {
    static int T, N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, 0};
    static int[] dy = {0, -1, 1};
    static int[] start;
    static int[] finish;
    static int[][] D;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        T = Integer.parseInt(st.nextToken());   // 테스트 횟수
        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(bf.readLine());

            N = Integer.parseInt(st.nextToken());   // 행
            M = Integer.parseInt(st.nextToken());   // 열 크기
            // 초기화
            map = new char[N][M];
            visited = new boolean[N][M];
            D = new int[N][M];
            start = new int[2];
            finish = new int[2];

            for(int i = 0; i < N; i++) {    // 행
                char[] ch = bf.readLine().toCharArray();

                for(int j = 0; j < M; j++) {    // 열
                    map[i][j] = ch[j];  // 저장

                    if(map[i][j] == 'S') {  // 시작점 저장
                        start[0] = i;
                        start[1] = j;
                    }

                    if(map[i][j] == 'F') {  // 끝점 저장
                        finish[0] = i;
                        finish[1] = j;
                    }
                }
            }

            System.out.println(BFS(start[0], start[1]));    // BFS 수행
        }
    }

    public static boolean notValidPos(int x, int y) {   // 유효한 좌표인지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static int BFS(int x, int y) {   // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신
        D[x][y] = 1;    // 거리 1

        while(!queue.isEmpty()) {   // 큐가 비어있지않으면
            int[] now = queue.poll();   // 하나 꺼내어
            int nowX = now[0], nowY = now[1];   // 좌표

            if(nowX == finish[0] && nowY == finish[1])  // 끝점이면
                return D[nowX][nowY];   // 총 거리 출력

            for(int i = 0; i < 3; i++) {    // 위 제외, 3방향
                int tmpX = nowX + dx[i];
                int tmpY = nowY + dy[i];

                if(notValidPos(tmpX, tmpY) || visited[tmpX][tmpY])  // 좌표가 유효한지
                    continue;
                // 아래로 향하는 방향일 때 => i == 0, 오른쪽 아래 대각선 방향으로 이동가능한지
                if(i == 0 && map[tmpX][tmpY] == 'X' && (tmpY + 1 < M) && (map[tmpX][tmpY + 1] == 'O' || map[tmpX][tmpY + 1] == 'F')) {
                    visited[tmpX][tmpY + 1] = true; // 방문여부 갱신
                    D[tmpX][tmpY + 1] = D[nowX][nowY] + 1;  // 거리값 증가
                    queue.offer(new int[] {tmpX, tmpY + 1});    // 큐에 삽입
                } else if(map[tmpX][tmpY] == 'O' || map[tmpX][tmpY] == 'F') {
                    visited[tmpX][tmpY] = true;
                    D[tmpX][tmpY] = D[nowX][nowY] + 1;
                    queue.offer(new int[] {tmpX, tmpY});
                }
            }
        }

        return -1;  // 도달하지 못하면 -1
    }
}
