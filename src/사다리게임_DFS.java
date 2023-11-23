import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 사다리게임_DFS {
    static int N, M, S; // 크기
    static char[][] map;    // 입력배열
    static int[] res;   // 결과배열
    static boolean[][] visited; // 방문배열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        // 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N + 1][M];
        res = new int[N + 1];

        for (int i = 1; i < 2 * N; i++) {   // 2N - 1
            String str = bf.readLine();
            String[] s = str.split("");

            if (i % 2 == 1)
                for (int j = 0; j < M; j++)
                    map[(i + 1) / 2][j] = s[j].charAt(0);
        }
    }

    public static void DFS(int v, int w) {  // DFS

        // 베이스케이스
        if (visited[v][w])  // 방문한 적이 있으면
            return; // 건너뛰기

        // 재귀케이스
        visited[v][w] = true;   // 방문한 적이 없으면 방문

        if (w == M - 1) {   // 도달하면
            res[v] = S; // 결과배열 저장
            return; // 함수 리턴
        }

        if (map[v][w] == '|') { // 벽이면
            DFS(v, w + 1);
        } else {    // 아니면
            if (v > 1 && map[v - 1][w] == '+' && !visited[v - 1][w])
                DFS(v - 1, w);
            else if (v < 4 && map[v + 1][w] == '+' && !visited[v + 1][w])
                DFS(v + 1, w);
            else
                DFS(v, w + 1);
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        for (int i = 1; i <= N; i++) {  // 크기만큼
            S = i;  // 시작점 초기화
            visited = new boolean[N + 1][M];    // 방문배열 초기화
            DFS(i, 0);  // DFS
        }

        for (int i = 1; i <= N; i++)    // 크기만큼
            System.out.print(res[i]);   // 결과배열 출력
    }
}