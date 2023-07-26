import java.util.*;
import java.io.*;

/*
1 1
0
2 2
0 1
1 0
3 2
1 1 1
1 1 1
5 4
1 0 1 0 0
1 0 0 0 0
1 0 1 0 1
1 0 0 1 0
5 4
1 1 1 0 1
1 0 1 0 1
1 0 1 0 1
1 0 1 1 1
5 5
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0 0 0 0
1 0 1 0 1
0 0
 */

public class 섬의개수_백준 {
    static int N, M;    // 크기
    static int[][] map; // 입력배열
    static boolean[][] visited; // 방문배열
    static StringBuilder sb;    // 결과 문자열
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};  // 8방향
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void init(BufferedReader bf) throws IOException { // 초기화

        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        M = Integer.parseInt(st.nextToken());   // 열
        N = Integer.parseInt(st.nextToken());   // 행

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {    // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < M; j++)  // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문 여부 갱신

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for(int i = 0; i < 8; i++) {    // 8방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 땅이면
                    visited[tmpX][tmpY] = true; // 방문 여부 갱신
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void findIsland() {  // 섬 개수 출력

        int count = 0;  // 개수

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 1 && !visited[i][j]) {  // 땅이고 방문한 적이 없으면
                    BFS(i, j);  // BFS
                    count++;    // 개수 카운트
                }
            }
        }

        sb.append(count + "\n");    // 결과 문자열에 개수 추가
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        sb = new StringBuilder();   // 결과 문자열

        while(true) {
            init(bf); // 초기화

            if(N == 0 && M == 0)    // 둘 다 0 이면
                break;  // while 종료

            findIsland();  // 섬 개수
        }

        System.out.print(sb);   // 결과 출력
    }
}
