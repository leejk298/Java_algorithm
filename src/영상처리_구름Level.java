import java.io.*;
import java.util.*;

public class 영상처리_구름Level {
    public static int N, M;
    public static char[][] map;
    public static boolean[][] visited;
    public static int count;
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for(int i = 0; i < N; i++) {
            char[] ch = bf.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                map[i][j] = ch[j];
            }
        }

        int max = 0, num = 0;
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == '#' && !visited[i][j]) {
                    count = 1;
                    DFS(i, j);
                    num++;

                    if(max < count)
                        max = count;
                }
            }
        }

        System.out.println(num);
        System.out.println(max);
    }

    public static boolean validPos(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }

    public static void DFS(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if(validPos(tmpX, tmpY) && !visited[tmpX][tmpY] && map[tmpX][tmpY] == '#') {
                count++;
                DFS(tmpX, tmpY);
            }
        }
    }
}