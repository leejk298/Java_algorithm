import java.io.*;
import java.util.*;

public class 미로찾기_BFS_027 {
    static int dx[] = {0, 1, 0, -1}; // 4 방향
    static int dy[] = {1, 0, -1, 0}; // 하 우 상 좌
    static boolean visited[][]; // 방문배열
    static int A[][]; // 최단경로 배열
    static int N, M; // 행, 열

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine()); // 한 줄 스트링

        N = Integer.parseInt(st.nextToken()); // 행
        M = Integer.parseInt(st.nextToken()); // 열

        // 초기화
        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) { // 행 개수만큼
            st = new StringTokenizer(bf.readLine()); // 한 줄 스트링
            String str = st.nextToken(); // 문자열로 저장

            for (int j = 0; j < M; j++) // 열 개수만큼
                A[i][j] = Integer.parseInt(str.substring(j, j + 1)); // 문자열을 문자로 나누고 정수로 파싱
        }
    }

    public static void BFS(int x, int y) { // BFS

        Queue<int[]> queue = new LinkedList<>(); // 정수형 배열을 갖는 큐 구형

        queue.add(new int[]{x, y}); // 시작점 추가
        visited[x][y] = true; // 방문배열 갱신

        while (!queue.isEmpty()) { // 큐가 비어있지않으면 반복
            int now[] = queue.poll(); // 하나 꺼내어

            for (int i = 0; i < 4; i++) { // 4 방향으로
                int tmpX = now[0] + dx[i], tmpY = now[1] + dy[i];

                if (x >= 0 && y >= 0 && tmpX < N && tmpY < M) { // 유효한 지
                    if (A[tmpX][tmpY] != 0 && !visited[tmpX][tmpY]) { // 갈 수 있고 방문하지않았으면
                        visited[tmpX][tmpY] = true; // 방문하여
                        A[tmpX][tmpY] = A[now[0]][now[1]] + 1; // 핵심 => 깊이 정보 갱신 => 최단경로
                        queue.add(new int[]{tmpX, tmpY}); // 큐에 삽입
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS(0, 0); // (0, 0)에서부터 BFS 시작

        System.out.println(A[N - 1][M - 1]); // 마지막 경로값 출력
    }
}
