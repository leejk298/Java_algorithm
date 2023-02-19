import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리게임2_DFS {
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

        for(int i = 1; i <= N; i++) {
            S = i;
            visited = new boolean[N + 1][M];
            DFS(i, 0);
        }

        for(int i = 1; i <= N; i++)
            System.out.println(res[i]);
        System.out.println();

    }

    static void DFS(int v, int w) {
        if(w == M) {
            res[v] = S;
            return;
        }

        if(visited[v][w])
            return;

        visited[v][w] = true;

        if(map[v][w] == '|') {
            DFS(v, w + 1);
        } else {
            int[] arr = findChar(v, w, map[v][w]);

            if(arr[0] == v && arr[1] == w)
                DFS(v, w + 1);
            else
                DFS(arr[0], arr[1]);
        }
    }

    static int[] findChar(int v, int w, char ch) {
        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == ch && !visited[i][j])
                    return new int[] {i, j};
            }
        }

        return new int[] {v, w};
    }
}