import java.util.*;
import java.io.*;

/*
6 7 3
.......
...O...
....O..
.......
OO.....
OO.....
 */

public class 봄버맨_백준 {
    static int N, M, sec;   // 크기, 시간
    static char[][] map;    // 맵
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue;  // 큐

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        sec = Integer.parseInt(st.nextToken()); // 시간

        // 초기화
        map = new char[N][M];
        queue = new LinkedList<>();

        for(int i = 0; i < N; i++)
            map[i] = bf.readLine().toCharArray();   // 맵 저장
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS() {  // BFS

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어
            int nowX = now[0], nowY = now[1];   // 좌표

            map[nowX][nowY] = '.';  // 갱신

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 'O')  // 폭발 가능하면
                    map[tmpX][tmpY] = '.';  // 갱신
            }
        }
    }

    public static void caseOfMapState() {   // 맵 상태에 따른 경우

        for(int t = 2; t <= sec; t++) { // 2부터 주어진 시간까지 시뮬레이션
            // 1이면 그냥 초기상태와 동일하므로 2부터
            if(t % 2 == 1) {    //  홀수이면

                for(int i = 0; i < N; i++)  // 행
                    for(int j = 0; j < M; j++)  // 열
                        if(map[i][j] == 'O')    // 폭탄이면
                            queue.offer(new int[] {i, j});  // 큐에 삽입

                for(char[] m : map) // 전부 채워넣기
                    Arrays.fill(m, 'O');

                BFS();  // BFS
            }
        }

        if(sec % 2 == 0) {  // 짝수이면

            for(char[] m : map) // 전부 채워넣기
                Arrays.fill(m, 'O');
        }

        // 시뮬레이션 다 끝나고 출력
        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                System.out.print(map[i][j]); // 출력
            }

            System.out.println();   // 개행문자 출력
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        caseOfMapState(); // 시간에 따른 맵 상태 출력
    }
}
