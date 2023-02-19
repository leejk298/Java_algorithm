import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리게임_DFS {
    static int N, M, S;
    static char[][] map;
    static int[] res;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M];
        res = new int[N + 1];

        for (int i = 1; i < 2 * N; i++) {
            String str = bf.readLine();
            String[] s = str.split("");

            if (i % 2 == 1) {
                for (int j = 0; j < M; j++) {
                    map[(i + 1) / 2][j] = s[j].charAt(0);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            S = i;
            visited = new boolean[N + 1][M];
            DFS(i, 0);
        }

        for (int i = 1; i <= N; i++)
            System.out.print(res[i]);
        System.out.println();
    }

    static void DFS(int v, int w) {
        if (visited[v][w])
            return;

        visited[v][w] = true;

        if (w == M - 1) {
            res[v] = S;
            return;
        }

        if (map[v][w] == '|') {
            DFS(v, w + 1);
        } else {
            if (v > 1 && map[v - 1][w] == '+' && !visited[v - 1][w])
                DFS(v - 1, w);
            else if (v < 4 && map[v + 1][w] == '+' && !visited[v + 1][w])
                DFS(v + 1, w);
            else
                DFS(v, w + 1);
        }
    }
}