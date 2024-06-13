import java.util.*;
import java.io.*;

/*
3 6
D...*.
.X.X..
....S.
 */

public class 탈출_백준 {
    static int N, M, answer;    // 크기
    static char[][] map;    // 맵
    static int[] dx = {-1, 1, 0, 0};    // 4방향    
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> sQ; // S
    static Queue<int[]> xQ; // *

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기
        M = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE; // 최단거리, 최대값으로 초기화

        sQ = new LinkedList<>();    // S 좌표
        xQ = new LinkedList<>();    // * 좌표

        map = new char[N][M];   // 초기화
        for (int i = 0; i < N; i++) {   // 행
            String str = bf.readLine(); // 한 줄 스트링

            for (int j = 0; j < M; j++) {   // 열
                map[i][j] = str.charAt(j);  // 문자

                if (map[i][j] == '*')   // * 이면
                    xQ.offer(new int[]{i, j});

                if (map[i][j] == 'S')   // S 이면
                    sQ.offer(new int[]{i, j, 0});   // 좌표와 거리
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) {    // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static boolean BFS() {   // BFS

        while (!sQ.isEmpty()) {  // S가 있으면
            int xSize = xQ.size();  // * 크기 -> 한 회전씩 돌기위해
            for (int i = 0; i < xSize; i++) {    // 크기만큼
                int[] now = xQ.poll();  // 하나 꺼내어

                int nowX = now[0], nowY = now[1];   // 좌표

                for (int k = 0; k < 4; k++) {    // 4방향
                    int tmpX = nowX + dx[k], tmpY = nowY + dy[k];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY))  // 유효한지
                        continue;

                    if (map[tmpX][tmpY] == '.') {    // . 이면
                        map[tmpX][tmpY] = '*';  // * 로 바꿈
                        xQ.offer(new int[]{tmpX, tmpY});   // 큐에 삽입 -> 다음 회전에서 사용
                    }
                }
            }

            int sSize = sQ.size();  // S 크기 -> 한 회전씩

            for (int i = 0; i < sSize; i++) {    // 크기만큼
                int[] now = sQ.poll();  // 하나 꺼내어
                int nowX = now[0], nowY = now[1], nowD = now[2];    // 좌표, 거리

                for (int k = 0; k < 4; k++) {    // 4방향
                    int tmpX = nowX + dx[k], tmpY = nowY + dy[k];   // 다음 좌표

                    if (isNotValidPos(tmpX, tmpY))  // 유효한지
                        continue;

                    if (map[tmpX][tmpY] == 'D') {    // D 이면, 도착이면
                        answer = Math.min(answer, nowD + 1);    // 최소값, 값이 여러개 나올 수 있으므로

                        return true;    // true 리턴
                    }

                    if (map[tmpX][tmpY] == '.') {    // . 이면, 갈 수 있으면
                        map[tmpX][tmpY] = 'S';  // S 로 바꿈
                        sQ.offer(new int[]{tmpX, tmpY, nowD + 1}); // 좌표와 거리 + 1 저장, 다음 회전에 사용
                    }
                }
            }
        }

        return false;   // 여기로 오면 false 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        if (BFS())   // true 이면
            System.out.print(answer);   // 최단거리 출력
        else    // false 이면
            System.out.print("KAKTUS");  // KAKTUS 출력
    }
}
