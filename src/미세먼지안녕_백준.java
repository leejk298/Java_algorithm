import java.util.*;

/*
7 8 1
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */

public class 미세먼지안녕_백준 {
    static int N, M, T; // 크기
    static int[][] map, copy;   // 입력, 복사배열
    static List<int[]> list;    // 공기청정기 좌표
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() {  // 초기화

        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 행
        M = sc.nextInt();   // 열
        T = sc.nextInt();   // 시간

        // 초기화
        map = new int[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {   // 행
            for (int j = 0; j < M; j++) {   // 열
                map[i][j] = sc.nextInt();   // 맵 저장

                if (map[i][j] == -1)    // -1 이면
                    list.add(new int[]{i, j});  // 공기청정기 좌표 저장
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS

        int count = 0;  // 개수
        for(int i = 0; i < 4; i++) {    // 4방향
            int tmpX = x + dx[i], tmpY = y + dy[i]; // 다음 좌표

            if(isNotValidPos(tmpX, tmpY) || map[tmpX][tmpY] == -1)  // 유효한지
                continue;

            copy[tmpX][tmpY] += map[x][y] / 5;  // 복사배열에 저장
            count++;    // 개수 카운트
        }

        copy[x][y] += map[x][y] - (map[x][y] / 5) * count;  // 해당 좌표값 복사
    }

    public static void act1() { // 미세먼지 확산

        copy = new int[N][M];   // 복사배열 초기화

        for(int i = 0; i < N; i++)  // 행
            for(int j = 0; j < M; j++)    // 열
                if(map[i][j] != 0 && map[i][j] != -1)   // 0과 -1이 아니면
                    BFS(i, j);  // BFS

        // 복사
        for(int i = 0; i < N; i++)  // 행
            for(int j = 0; j < M; j++)  // 열
                map[i][j] = copy[i][j]; // 복사

        for(int i = 0; i < list.size(); i++) { // 공기청정기 개수만큼
            int[] now = list.get(i);
            int nowX = now[0], nowY = now[1];

            map[nowX][nowY] = -1;   // 복사
        }
    }

    public static void func1(int x, int y) {    // 반시계 방향

        for(int i = x - 1; i > 0; i--)  // 위 -> 아래
            map[i][0] = map[i - 1][0];

        for(int i = 0; i < M - 1; i++)  // 왼 -> 오
            map[0][i] = map[0][i + 1];

        for(int i = 0; i < x; i++)  // 아래 -> 위
            map[i][M - 1] = map[i + 1][M - 1];

        for(int i = M - 1; i > 1; i--)  // 오 -> 왼
            map[x][i] = map[x][i - 1];

        map[x][1] = 0;  // 공기청정기 바로 앞에는 0
    }

    public static void func2(int x, int y) {    // 시계 방향

        for(int i = x + 1; i < N - 1; i++)  // 아래 -> 위
            map[i][0] = map[i + 1][0];

        for(int i = 0; i < M - 1; i++)  // 왼 -> 오
            map[N - 1][i] = map[N - 1][i + 1];

        for(int i = N - 1; i > x; i--)  // 위 -> 아래
            map[i][M - 1] = map[i - 1][M - 1];

        for(int i = M - 1; i > 1; i--)  // 오 -> 왼
            map[x][i] = map[x][i - 1];

        map[x][1] = 0;   // 공기청정기 바로 앞에는 0
    }

    public static void act2() { // 공기청정기 작동

        for(int i = 0; i < list.size(); i++) {  // 개수만큼
            int now[] = list.get(i);    // 꺼내어
            int nowX = now[0], nowY = now[1];   // 좌표

            if(i % 2 == 0)  // 위
                func1(nowX, nowY);  // 반시계 방향 작동
            else    // 아래
                func2(nowX, nowY);  // 시계 방향 작동
        }
    }

    public static void printAmount() {  // 총 미세먼지 양 출력

        int res = 0;    // 합
        for(int i = 0; i < N; i++)  // 행
            for(int j = 0; j < M; j++)  // 열
                if(map[i][j] != -1) // 공기청정기가 아니면
                    res += map[i][j];   // 더해서

        System.out.println(res);    // 총 합 출력
    }

    public static void main(String[] args) {

        init(); // 초기화

        while(T-- > 0) {    // 시간만큼

            act1(); // 미세먼지 확산

            act2(); // 공기청정기 작동
        }

        printAmount();  // 총 미세먼지 양 출력
    }
}
