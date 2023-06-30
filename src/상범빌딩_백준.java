import java.util.*;
import java.io.*;

/*
3 4 5
S....
.###.
.##..
###.#

#####
#####
##.##
##...

#####
#####
#.###
####E

1 3 3
S##
#E#
###

0 0 0
 */

public class 상범빌딩_백준 {
    static int H, N, M, res;    // 크기, 결과
    static char[][][] map;  // 입력배열
    static boolean[][][] visited;   // 방문배열
    static int[][][] D; // 거리배열
    static int[] dh = {-1, 1, 0, 0, 0, 0};  // 6방향
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, 0, -1, 1};
    static int[] S, E;  // 시작, 도착좌표
    static boolean end; // while 종료조건

    public static void init(BufferedReader bf) throws IOException { // 초기화

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        H = Integer.parseInt(st.nextToken());   // 높이
        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        res = 0;    // 결과값
        end = false;    // 종료조건

        if (H == 0 && N == 0 && M == 0) {   // 종료조건
            end = true;

            return; // 리턴
        }

        // 초기화
        map = new char[H][N][M];
        visited = new boolean[H][N][M];
        D = new int[H][N][M];

        for (int i = 0; i < H; i++) {   // 높이
            if (i != 0) // 두 번째부터는
                bf.readLine();  // 개행제거
            for (int j = 0; j < N; j++) {   // 가로
                String str = bf.readLine(); // 한 줄 스트링

                for (int k = 0; k < M; k++) {   // 세로
                    map[i][j][k] = str.charAt(k);   // 입력배열 저장

                    if (map[i][j][k] == 'S')    // 시작
                        S = new int[]{i, j, k}; // 좌표 저장

                    if (map[i][j][k] == 'E')    // 끝
                        E = new int[]{i, j, k}; // 좌표 저장
                }
            }
        }

        bf.readLine();  // 한 줄 스트링
    }

    public static boolean isNotValidPos(int h, int x, int y) {  // 좌표가 유효한지

        return (h < 0 || h >= H || x < 0 || x >= N || y < 0 || y >= M);
    }

    public static boolean BFS() {   // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(S); // 시작점 큐에 삽입
        visited[S[0]][S[1]][S[2]] = true;   // 시작점 방문
        D[S[0]][S[1]][S[2]] = 0;    // 거리 0부터 시작

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowH = now[0], nowX = now[1], nowY = now[2];    // 현재 좌표

            if (nowH == E[0] && nowX == E[1] && nowY == E[2]) { // 도착점에 도달하면
                res = D[nowH][nowX][nowY];  // 결과값 저장

                return true;    // true 리턴
            }

            for (int i = 0; i < 6; i++) {   // 6방향
                int tmpH = nowH + dh[i], tmpX = nowX + dx[i], tmpY = nowY + dy[i];  // 다음 좌표

                if (isNotValidPos(tmpH, tmpX, tmpY) || visited[tmpH][tmpX][tmpY])   // 유효한지
                    continue;

                if (map[tmpH][tmpX][tmpY] == '.' || map[tmpH][tmpX][tmpY] == 'E') { // . 이나 E 이면
                    visited[tmpH][tmpX][tmpY] = true;   // 방문
                    D[tmpH][tmpX][tmpY] = D[nowH][nowX][nowY] + 1;  // 거리 갱신
                    queue.offer(new int[]{tmpH, tmpX, tmpY});   // 큐에 삽입
                }
            }
        }

        return false;   // false 리턴
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 한 줄 스트링
        StringBuilder sb = new StringBuilder(); // 결과 문자열

        while (true) {  // 무한 반복

            init(bf);   // 초기화

            if (end)    // 종료 조건
                break;

            if (BFS())  // BFS, 도달 가능하면
               sb.append("Escaped in " + res + " minute(s).\n");    // 얼마나 걸렸는지
            else    // 도달 불가능하면
               sb.append("Trapped!\n"); // 문자열 추가
        }

        System.out.print(sb);   // 결과 출력
    }
}
