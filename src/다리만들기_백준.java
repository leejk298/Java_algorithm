import java.util.*;
import java.io.*;

/*
10
1 1 1 0 0 0 0 1 1 1
1 1 1 1 0 0 0 0 1 1
1 0 1 1 0 0 0 0 1 1
0 0 1 1 1 0 0 0 0 1
0 0 0 1 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 1
0 0 0 0 0 0 0 0 0 0
0 0 0 0 1 1 0 0 0 0
0 0 0 0 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0
 */

public class 다리만들기_백준 {
    static int N, res, sNum;    // 크기, 결과값, 섬 개수
    static int[][] map; // 입력배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    static class Point {    // 내부클래스
        int x, y, len;  // 좌표, 길이

        public Point(int x, int y) {    // 좌표
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int len) {   // 오버로딩
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    public static void init() throws IOException {  // 초기화
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼

        N = Integer.parseInt(bf.readLine());    // 크기
        res = Integer.MAX_VALUE;    // 결과값
        sNum = 0;   // 섬 개수

        // 초기화
        map = new int[N][N];
        for(int i = 0; i < N; i++) {    // 행
            StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < N; j++)   // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void makeIsland(int x, int y) {   // 섬 만들기

        Queue<Point> queue = new LinkedList<>();    // 큐

        queue.offer(new Point(x, y));   // 시작점 큐에 삽입
        visited[x][y] = true;   // 시작점 방문
        map[x][y] += sNum;  // 입력배열에 섬 표시

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Point now = queue.poll();   // 하나 꺼내어

            int nowX = now.x, nowY = now.y; // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 섬이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    map[tmpX][tmpY] += sNum;    // 섬 표시
                    queue.offer(new Point(tmpX, tmpY)); // 큐에 삽입
                }
            }
        }
    }

    public static void findIsland() {   // 섬 찾기

        visited = new boolean[N][N];    // 방문배열 초기화

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < N; j++) {    // 열
                if(map[i][j] == 1 && !visited[i][j]) {  // 육지고 방문한 적이 없으면
                    makeIsland(i, j);   // BFS
                    sNum++; // 섬 이름
                }
            }
        }
    }

    public static void makeBridge(int x, int y) {    // 다리 만들기

        Queue<Point> queue = new LinkedList<>();    // 큐

        queue.offer(new Point(x, y, 0));    // 시작점과 길이 큐에 삽입
        visited[x][y] = true;   // 시작점 방문
        int num = map[x][y];    // 현재 섬 이름

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            Point now = queue.poll();   // 하나 꺼내어

            int nowX = now.x, nowY = now.y, len = now.len;  // 현재 좌표, 길이
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY] || map[tmpX][tmpY] == num)  // 유효한 지, 같은 섬이면 건너뛰기
                    continue;

                if(map[tmpX][tmpY] == 0) {  // 바다이면
                    queue.offer(new Point(tmpX, tmpY, len + 1));    // 길이 증가시켜서 큐에 삽입, 다리
                    visited[tmpX][tmpY] = true; // 방문
                } else {    // 다른 섬이면
                    res = Math.min(res, len);   // 최소값 저장

                    return; // 해당 육지에서 최단 경로는 이미 나왔으므로 함수 종료
                }
            }
        }
    }

    public static void findBridge() {   // 다리 찾기

        visited = new boolean[N][N];    // 방문배열 초기화

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < N; j++) {    // 열
                if(map[i][j] != 0 && !visited[i][j]) {  // 육지고 방문한 적이 없으면
                    makeBridge(i, j);   // BFS, 다리 만들기
                    visited = new boolean[N][N];    // 방문배열 초기화, 육지마다 바다로 가는 경로가 겹치므로
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findIsland();   // 섬 찾기, 만들기

        findBridge();   // 다리 찾기, 만들기

        System.out.println(res);    // 결과값 출력
    }
}
