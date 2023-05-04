import java.util.*;

/*
15 15
2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
 */

public class 쉬운최단거리_백준 {
    static int N, M, sX, sY;
    static int[][] map, D;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void init() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        D = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                D[i][j] = Integer.MAX_VALUE;
                map[i][j] = sc.nextInt();

                if(map[i][j] == 2) {
                    sX = i;
                    sY = j;
                }
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) {
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {x, y});
        visited[x][y] = true;
        D[x][y] = 0;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            int nowX = now[0], nowY = now[1];
            for(int i = 0; i < 4; i++) {
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])
                    continue;

                if(map[tmpX][tmpY] == 1 && D[tmpX][tmpY] > D[nowX][nowY] + 1) {
                    visited[tmpX][tmpY] = true;
                    D[tmpX][tmpY] = D[nowX][nowY] + 1;
                    queue.offer(new int[] {tmpX, tmpY});
                }
            }
        }
    }

    public static void printMap() {

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1 && !visited[i][j])
                    D[i][j] = -1;

                if(map[i][j] == 0 && D[i][j] == Integer.MAX_VALUE)
                    D[i][j] = 0;

                System.out.print(D[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        init();

        BFS(sX, sY);

        printMap();
    }
}
