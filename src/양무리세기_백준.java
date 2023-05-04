import java.util.*;
import java.io.*;

/*
2
4 4
#.#.
.#.#
#.##
.#.#
3 5
###.#
..#..
#.###
 */

public class 양무리세기_백준 {
    static int N, M, K; // 크기
    static char[][] map;    // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init(BufferedReader bf) throws IOException { // 초기화
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new char[N][M];
        visited = new boolean[N][M];

        // 맵 저장
        for(int i = 0; i < N; i++) {
            char[] ch = bf.readLine().toCharArray();

            for(int j = 0; j < M; j++) {
                map[i][j] = ch[j];
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == '#') {    // # 이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static int checkSheep() {    // 양 무리 세기
        int count = 0;  // 개수

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == '#' && !visited[i][j]) {    // # 이고 방문하지 않았으면
                    BFS(i, j);  // BFS
                    count++;    // 개수 카운트
                }
            }
        }

        return count;   // 개수 리턴
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        K = Integer.parseInt(st.nextToken());   // 테스트 횟수
        for(int i = 0; i < K; i++) {    // 횟수만큼

            init(bf);   // 초기화

            System.out.println(checkSheep());   // 양 무리 개수 출력
        }
    }
}
