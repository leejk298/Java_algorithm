import java.util.*;

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
    static int N, M, count; // 크기, 최대 개수
    static int[][] map;     // 맵
    static int[][] copy;    // 복사
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열

        // 초기화
        count = 0;
        map = new int[N][M];

        // 맵 저장
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                map[i][j] = sc.nextInt();
    }

    public static void copyArray(Queue<int[]> queue) {  // 배열 복사

        copy = new int[N][M];   // 초기화

        // 복사
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = map[i][j];

                if(copy[i][j] == 2) // 2이면
                    queue.offer(new int[] {i, j});  // 큐에 삽입
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS() {  // BFS

        Queue<int[]> queue = new LinkedList<>();    // 큐

        copyArray(queue);   // 큐 넘겨서 바이러스 좌표 구함

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int now[] = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(copy[tmpX][tmpY] == 0) { // 0이면
                    copy[tmpX][tmpY] = 2;   // 2로 바꿈, 퍼지는거
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }

        findMaxCount(copy); // 0인 지역 개수 찾기
    }

    public static void DFS(int depth) { // DFS, 브루트포스

        if(depth == 3) {    // 3이면
            BFS();  // BFS

            return; // 리턴
        }

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 0) {    // 0 이면
                    map[i][j] = 1;  // 1로, 벽

                    DFS(depth + 1); // 벽 개수 갱신하여 넘겨줌
                    map[i][j] = 0;  // 리턴되면 다시 0으로 갱신
                }
            }
        }
    }

    public static void findMaxCount(int[][] arr) {  // 0인 지역 개수 찾기
        
        int cnt = 0;    // 개수
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(arr[i][j] == 0)
                    cnt++;

        count = Math.max(count, cnt);   // 최대값
    }

    public static void main(String[] args) {
    
        init(); // 초기화

        DFS(0); // DFS

        System.out.print(count);    // 최대값 출력
    }
}
