import java.util.*;
import java.io.*;

/*
5
6 8 2 6 2
3 2 3 4 6
6 7 3 3 2
7 2 5 3 6
8 9 5 2 7
 */

public class 안전영역_백준 {
    static int N, count, maxHeight; // 크기, 결과값, 최대높이
    static boolean[][] visited; // 방문배열
    static int[][] map; // 입력배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        count = 0;  // 최대 영역 개수
        maxHeight = 0;  // 최대 높이
        map = new int[N][N];    // 입력배열

        for(int i = 0; i < N; i++) {    // 행
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < N; j++) {    // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 맵 저장
                maxHeight = Math.max(maxHeight, map[i][j]); // 최대 높이 저장
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS(int x, int y, int h) {   // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 큐에 삽입
        visited[x][y] = true;   // 시작점 방문 여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] > h) {   // 높이보다 높으면 침수 아니므로
                    visited[tmpX][tmpY] = true; // 방문
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void findMaxArea() {  // 최대 영역 찾기

        for(int h = 0; h <= maxHeight; h++) {   // 높이 만큼, 0부터 시작하는 이유: 높이가 1인 영역도 검사하기 위해
            int cnt = 0;    // 개수
            visited = new boolean[N][N];    // 방문배열 초기화

            for(int i = 0; i < N; i++) {    // 행
                for(int j = 0; j < N; j++) {    // 열
                    if(map[i][j] > h && !visited[i][j]) {   // 침수되지 않았고 방문하지 않았으면
                        BFS(i, j, h);   // BFS 수행
                        cnt++;  // 끝나면 영역 개수 카운트
                    }
                }
            }

            count = Math.max(count, cnt);   // 최대 영역 개수
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findMaxArea();  // 최대 영역 찾기

        System.out.println(count);  // 최대 영역 개수 출력
    }
}
