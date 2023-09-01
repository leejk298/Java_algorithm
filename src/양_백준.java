import java.util.*;
import java.io.*;

/*
8 8
.######.
#..o...#
#.####.#
#.#v.#.#
#.#.o#o#
#o.##..#
#.v..v.#
.######.
 */

public class 양_백준 {
    static int N, M, S, W;  // 크기
    static char[][] map;    // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new char[N][M];
        visited = new boolean[N][M];

        // 맵저장
        for(int i = 0; i < N; i++)
            map[i] = bf.readLine().toCharArray();
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void DFS(int x, int y) {  // DFS

        visited[x][y] = true;   // 방문여부 갱신

        // 양이나 늑대 개수 카운트
        if(map[x][y] == 'v')
            W++;
        if(map[x][y] == 'o')
            S++;

        for(int i = 0; i < 4; i++) {    // 4방향
            int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

            if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY] || map[tmpX][tmpY] == '#')  // 갈 수 없으면 건너뛰기
                continue;

            DFS(tmpX, tmpY);    // . 이거나 v 이거나 o 이면 이동가능
        }
    }

    public static int[] countSheepAndWolf() {   // 양, 늑대 개수 카운트

        int countS = 0, countW = 0; // 총 개수

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if((map[i][j] == 'o' || map[i][j] == 'v') && !visited[i][j]) {  // 방문하지 않았고 양이나 늑대인 경우
                    // 초기화
                    S = 0;
                    W = 0;

                    DFS(i, j);  // DFS

                    if(S > W)   // 양이 많으면
                        countS += S;    // 늑대 물리침
                    else    // 늑대가 같거나 크면
                        countW += W;    // 양 죽음
                }
            }
        }

        return new int[] {countS, countW};  // 총 양, 늑대 개수 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        int[] answer = countSheepAndWolf(); // 양, 늑대 개수

        System.out.print(answer[0] + " " + answer[1]);  // 출력
    }
}
