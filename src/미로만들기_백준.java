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
    static int[][] map; // 맵
    static int[][] D;   // 거리배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 크기

        // 초기화
        map = new int[N][N];
        D = new int[N][N];

        for(int i = 0; i < N; i++) {
            char[] ch = bf.readLine().toCharArray();

            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] - '0';    // 값 저장
                D[i][j] = Integer.MAX_VALUE;    // 최대값으로 초기화
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= N);
    }

    public static void BFS() {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {0, 0});  // 원점부터 시작
        D[0][0] = 0;    // 시작점 0

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY))   // 유효한지
                    continue;

                if(D[tmpX][tmpY] > D[nowX][nowY]) { // 거리가 짧으면 갱신
                    if(map[tmpX][tmpY] == 1)    // 1인 경우
                        D[tmpX][tmpY] = D[nowX][nowY];  // 그대로
                    else    // 0인 경우
                        D[tmpX][tmpY] = D[nowX][nowY] + 1;  // 비용 1 추가

                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        BFS();  // BFS

        System.out.println(D[N - 1][N - 1]);    // 최소 비용 출력
    }
}
