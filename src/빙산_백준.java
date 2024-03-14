import java.io.*;
import java.util.*;

/*
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
 */

public class 빙산_백준 {
    static int N, M;    // 크기
    static int[][] map; // 맵
    static int[][] copy;    // 복사배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException { // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        map = new int[N][M];    // 입력배열 초기화

        for (int i = 0; i < N; i++) {   // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < M; j++) //열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static void countZero() {    // 0 개수 세기

        copy = new int[N][M];   // 복사배열 초기화

        for (int i = 0; i < N; i++) {    // 행
            for (int j = 0; j < M; j++) {    // 열
                int count = 0;  // 0 개수

                if (map[i][j] != 0) {    // 0이 아니면
                    // 유효한 4방향 좌표에서 0 개수 카운트
                    if (i - 1 >= 0 && map[i - 1][j] == 0)
                        count++;
                    if (j - 1 >= 0 && map[i][j - 1] == 0)
                        count++;
                    if (i + 1 < N && map[i + 1][j] == 0)
                        count++;
                    if (j + 1 < M && map[i][j + 1] == 0)
                        count++;

                    copy[i][j] = count; // 복사배열에 값 저장
                }
            }
        }

        for (int i = 0; i < N; i++) {   // 행
            for (int j = 0; j < M; j++) {   // 열
                if (copy[i][j] != 0) {   // 0이 아니면
                    map[i][j] -= copy[i][j];    // 갱신

                    if (map[i][j] < 0)   // 0 보다 작아지면
                        map[i][j] = 0;  // 0 으로
                }
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신

        while (!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   //  좌표
            for (int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if (map[tmpX][tmpY] != 0) {  // 0이 아니면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    queue.offer(new int[]{tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static int findNum() {   // 빙산 개수

        visited = new boolean[N][M];    // 방문배열 갱신

        int num = 0;    // 빙산 개수
        for (int i = 0; i < N; i++) {    // 행
            for (int j = 0; j < M; j++) {    // 열
                if (map[i][j] != 0 && !visited[i][j]) {  // 0이 아니고 방문하지 않았으면
                    BFS(i, j);  // BFS
                    num++;  // 빙산 개수 카운트
                }
            }
        }

        return num; // 개수 리턴
    }

    public static int findYear() {  // 얼마나 걸리는지

        int year = 0;   // 몇 년

        while (true) {
            year++; // 년수 카운트

            countZero();    // 주변의 0 개수에 맞게 제거

            if (findNum() != 1) {    // 빙산 개수가 1개가 아니면
                if (findNum() == 0)    // 0개이면 다 없어진 경우이므로
                    year = 0;   // 0
                break;  // while 종료
            }
        }

        return year; // 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.print(findYear()); // 얼마나 걸리는지 출력
    }
}
