import java.util.*;
import java.io.*;

/*
3 5
OOOPO
OIOOX
OOOXP
 */

public class 헌내기는친구가필요해_백준 {
    static int N, M, count; // 크기, 결과값
    static int startX, startY;  // 시작좌표
    static char[][] map;    // 입력배열
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        count = 0;  // 결과값

        map = new char[N][M];   // 입력배열
        visited = new boolean[N][M];    // 방문배열

        for (int i = 0; i < N; i++) {   // 행
            char[] ch = bf.readLine().toCharArray();    // 문자배열

            for (int j = 0; j < M; j++) {   // 열
                map[i][j] = ch[j];  // 입력배열 저장

                if (map[i][j] == 'I') { // 시작점이면
                    startX = i; // 좌표 저장
                    startY = j;
                }
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 시작점 큐에 추가
        visited[x][y] = true;   // 방문

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재좌표

            if (map[nowX][nowY] == 'P') // P이면
                count++;    // 개수 카운트

            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])   // 유효한지
                    continue;

                if (map[tmpX][tmpY] != 'X') {   // X이면
                    visited[tmpX][tmpY] = true; // 방문
                    queue.offer(new int[]{tmpX, tmpY}); // 큐에 추가
                }
            }
        }
    }

    public static void findCount() {    // 개수 찾기

        BFS(startX, startY);    // BFS

        if (count == 0) // 0이면
            System.out.println("TT");   // TT 출력
        else    // 0이 아니면
            System.out.println(count);  // 개수 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findCount();    // 개수 찾기
    }
}
