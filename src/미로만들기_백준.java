import java.util.*;
import java.io.*;

/*
8
11100110
11010010
10011010
11101100
01000111
00110001
11011000
11000111
 */

public class 미로만들기_백준 {
    static int N;   // 크기
    static int[][] map, D;  // 입력, 비용배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기

        // 초기화
        map = new int[N][N];
        D = new int[N][N];

        for(int i = 0; i < N; i++) {    // 행
            char[] ch = bf.readLine().toCharArray();    // 한 줄 스트링을 문자배열로 저장

            for(int j = 0; j < N; j++) {    // 열
                map[i][j] = ch[j] - '0';    // 입력배열 저장
                D[i][j] = Integer.MAX_VALUE;    // 비용배열 최대값으로 초기화
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지

        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 큐에 삽입
        D[x][y] = 0;    // 비용 0으로 초기화

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한 지
                    continue;

                if(D[nowX][nowY] < D[tmpX][tmpY]) { // 현재 비용이 더 작으면
                    if(map[tmpX][tmpY] == 1) {  // 다음 좌표가 흰 방이면
                        D[tmpX][tmpY] = D[nowX][nowY];  // 그대로
                    } else {    // 검은 방이면
                        D[tmpX][tmpY] = D[nowX][nowY] + 1;  // 비용 1 추가
                    }

                    queue.offer(new int[] {tmpX, tmpY});    // 다음 좌표 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS(0, 0);  // BFS, 시작점 (0, 0)

        System.out.println(D[N - 1][N - 1]);    // 도착점, 최소 비용 출력
    }
}
