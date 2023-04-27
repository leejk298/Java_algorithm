import java.util.*;
import java.io.*;

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
 */

public class 단지번호붙이기_백준 {
    static int N, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list;

    public static void init() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] ch = bf.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] - '0';
            }
        }
    }

    public static boolean isValidPos(int x, int y) {
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        count++;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            int nowX = now[0], nowY = now[1];
            for(int i = 0; i < 4; i++) {
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];

                if(isValidPos(tmpX, tmpY) || visited[tmpX][tmpY])
                    continue;

                if(map[tmpX][tmpY] == 1) {
                    visited[tmpX][tmpY] = true;
                    count++;
                    queue.offer(new int[] {tmpX, tmpY});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j);
                    list.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++)
            System.out.println(list.get(i));
    }
}
