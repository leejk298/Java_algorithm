import java.util.*;
import java.io.*;

/*
10 10
##########
#R#...##B#
#...#.##.#
#####.##.#
#......#.#
#.######.#
#.#....#.#
#.#.##...#
#O..#....#
##########
 */

public class 구슬탈출2_백준 {
    static int N, M;    // 크기
    static char[][] map;    // 입력배열
    static boolean[][][][] visited; // 방문배열, 4차원: 두 구슬을 모두 관리하기 위해
    static int bX, bY, rX, rY, hX, hY;  // 구슬, 구멍 좌표
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Marble {   // 구슬 클래스
        int rX, rY, bX, bY, count;  // 좌표, 이동횟수

        public Marble(int rX, int rY, int bX, int bY, int count) {  // 파라미터 생성자
            this.rX = rX;   // 빨강구슬의 x좌표
            this.rY = rY;   // 빨강구슬의 y좌표
            this.bX = bX;   // 파란구슬의 x좌표
            this.bY = bY;   // 파란구슬의 y좌표
            this.count = count; // 이동횟수
        }
    }

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        map = new char[N][M];   // 입력배열 초기화
        visited = new boolean[N][M][N][M];  // 방문배열

        for(int i = 0; i < N; i++) {    // 행
            String str = bf.readLine(); // 한 줄 스트링

            for(int j = 0; j < M; j++) {    // 열
                map[i][j] = str.charAt(j);  // 입력배열 저장

                if(map[i][j] == 'O') {  // 구멍
                    hX = i; // 좌표 저장
                    hY = j;
                }

                if(map[i][j] == 'B') {  // 파란구슬
                    bX = i;
                    bY = j;
                }

                if(map[i][j] == 'R') {  // 빨간구슬
                    rX = i;
                    rY = j;
                }
            }
        }
    }

    public static int BFS(int rX, int rY, int bX, int bY, int count) {  // BFS

        Queue<Marble> queue = new LinkedList<>();   // 큐

        queue.offer(new Marble(rX, rY, bX, bY, count)); // 시작점 큐에 삽입
        visited[rX][rY][bX][bY] = true; // 시작점 방문

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Marble now = queue.poll();  // 하나 꺼내어

            int nowRx = now.rX, nowRy = now.rY, nowBx = now.bX, nowBy = now.bY, nowCount = now.count;   // 현재 좌표와 이동횟수

            if(nowCount >= 10)  // 이동횟수가 10회 이상이면
                break;  // while 종료 -> -1 리턴

            for(int i = 0; i < 4; i++) {    // 4방향, 위, 아래, 왼, 오
                int tmpRx = nowRx, tmpRy = nowRy, tmpBx = nowBx, tmpBy = nowBy; // 다음 좌표
                int tmpCount = nowCount + 1;    // 이동횟수 + 1
                boolean isRed = false, isBlue = false;  // 구멍을 만났는지

                while(map[tmpRx + dx[i]][tmpRy + dy[i]] != '#') {   // 벽이 아니면
                    tmpRx += dx[i]; // 계속 이동
                    tmpRy += dy[i];

                    if(tmpRx == hX && tmpRy == hY) {    // 이동 중 구멍을 만나면
                        isRed = true;   // 갱신

                        break;  // while 종료
                    }
                }

                while(map[tmpBx + dx[i]][tmpBy + dy[i]] != '#') {   // 벽이 아니면
                    tmpBx += dx[i]; // 계속 이동
                    tmpBy += dy[i];

                    if(tmpBx == hX && tmpBy == hY) {    // 이동 중 구멍을 만나면
                        isBlue = true;  // 갱신

                        break;  // while 종료
                    }
                }

                if(isBlue)  // 파란구슬이 구멍에 들어가면
                    continue;   // 다음 구슬 객체

                if(isRed)   // 빨간구슬이 구멍에 들어가면
                    return tmpCount;    // 이동횟수 리턴

                if(tmpRx == tmpBx && tmpRy == tmpBy) { // 위, 아래, 왼, 오
                    if(i == 0) {    // 위
                        if(nowRx > nowBx)   // 더 아래에 있는 좌표가
                            tmpRx -= dx[i]; // 아래로
                        else
                            tmpBx -= dx[i];
                    } else if(i == 1) { // 아래
                        if(nowRx < nowBx)   // 더 위에 있는 좌표가
                            tmpRx -= dx[i]; // 위로
                        else
                            tmpBx -= dx[i];
                    } else if(i == 2) { // 왼
                        if(nowRy > nowBy)   // 더 오른쪽에 있는 좌표가
                            tmpRy -= dy[i]; // 오른쪽으로
                        else
                            tmpBy -= dy[i];
                    } else {    // 오른
                        if(nowRy < nowBy)   // 더 왼쪽에 있는 좌표가
                            tmpRy -= dy[i]; // 윈쪽으로
                        else
                            tmpBy -= dy[i];
                    }
                }

                if(!visited[tmpRx][tmpRy][tmpBx][tmpBy]) {  // 방문한 적이 없으면
                    visited[tmpRx][tmpRy][tmpBx][tmpBy] = true; // 방문
                    queue.offer(new Marble(tmpRx, tmpRy, tmpBx, tmpBy, tmpCount));  // 큐에 삽입
                }
            }
        }

        return -1;  // 여기로 도달하면 구멍에 도달하지 못하거나 10회 초과이므로 -1 리턴
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        System.out.println(BFS(rX, rY, bX, bY, 0)); // BFS, 이동횟수 출력
    }
}
