import java.util.*;
import java.io.*;

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
 */

public class 연구소_백준 {
    static int N, M;    // 크기
    static int[][] map, copy;   // 입력, 복사배열
    static int count;   // 결과값
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException { // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        count = 0;  // 결과값

        // 초기화
        map = new int[N][M];
        for (int i = 0; i < N; i++) {   // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for(int j = 0; j < M; j++)  // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장
        }
    }

    public static void copyArr(Queue<int[]> queue) {    // 복사배열 초기화

        // 초기화
        copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];

                if (copy[i][j] == 2)    // 바이러스이면
                    queue.offer(new int[]{i, j});   // 큐에 저장
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지

        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void findMaxCount() { // 최대 개수 찾기

        int cnt = 0;    // 개수
        for(int[] cp : copy)
            for (int c : cp)
                if(c == 0)  // 빈 칸이면
                    cnt++;  // 개수 카운트

        count = Math.max(count, cnt);   // 최대값 저장
    }

    public static void BFS() {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        copyArr(queue); // 복사배열 초기화, 큐에 바이러스 좌표 삽입

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(copy[tmpX][tmpY] == 0) { // 빈 칸이면
                    copy[tmpX][tmpY] = 2;   // 바이러스 전이
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }

        findMaxCount(); // 최대값 찾기
    }

    public static void DFS(int depth) { // 브루트포스

        // 베이스 케이스
        if (depth == 3) {   // 벽 3개 세웠으먄
            BFS();  // BFS 수행

            return; // 함수 리턴, 완전 탐색하기 위해
        }

        // 재귀 케이스
        for (int i = 0; i < N; i++) {   // 행
            for (int j = 0; j < M; j++) {   // 열
                if (map[i][j] == 0) {   // 빈 칸이면
                    map[i][j] = 1;  // 벽 세우기
                    DFS(depth + 1); // 개수 하나 늘려서 DFS, 재귀콜

                    map[i][j] = 0;  // 리턴되면 해당 벽 허물고 빈 칸으로 갱신
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        DFS(0); // DFS, 벽 개수 0부터

        System.out.println(count);  // 최대 개수 출력
    }
}
