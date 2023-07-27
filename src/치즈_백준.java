import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 1 1 0 0 0 0
0 0 0 1 1 0 1 1 0
0 0 1 1 1 1 1 1 0
0 0 1 1 1 1 1 0 0
0 0 1 1 0 1 1 0 0
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
 */

public class 치즈_백준 {
    static int N, M, count; // 크기, 개수
    static int[][] map; // 입력배열
    static List<int[]> list;    // 치즈리스트
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열
        count = 0;  // 개수

        // 초기화
        map = new int[N][M];
        list = new ArrayList<>();

        for (int i = 0; i < N; i++) {   // 행
            st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

            for (int j = 0; j < M; j++) {   // 열
                map[i][j] = Integer.parseInt(st.nextToken());   // 입력배열 저장

                if (map[i][j] == 1) {   // 치즈면
                    list.add(new int[]{i, j});  // 리스트에 추가
                    count++;    // 개수 카운트
                }
            }
        }
    }

    public static boolean isNotValidPos(int x, int y) { // 좌표가 유효한지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS, 외부공기 찾기

        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[]{x, y});   // 시작점 큐에 삽입
        visited[x][y] = true;   // 방문 여부 갱신
        map[x][y] = 2;  // 외부공기(2)로 바꾸기, 내부공기(0)

        while (!queue.isEmpty()) {  // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for (int i = 0; i < 4; i++) {   // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY] || map[tmpX][tmpY] == 1)   // 유효한지
                    continue;

                // 외부공기이면
                visited[tmpX][tmpY] = true; // 방문여부 갱신
                map[tmpX][tmpY] = 2;    // 외부공기로 바꾸고
                queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
            }
        }
    }

    public static void meltingCheese() {    // 치즈 녺이기

        for (int i = 0; i < list.size(); i++) { // 치즈 리스트 개수만큼
            int[] now = list.get(i);    // 하나씩 순회
            int nowX = now[0], nowY = now[1];   // 현재 좌표

            int cnt = 0;    // 외부공기 개수
            for (int k = 0; k < 4; k++) {   // 4방향
                int tmpX = nowX + dx[k], tmpY = nowY + dy[k];   // 다음 좌표

                if (map[tmpX][tmpY] == 2)   // 외부공기이면
                    cnt++;  // 개수 카운트
            }

            if (cnt >= 2) { // 2개 이상이면
                map[nowX][nowY] = 0;    // 녺이기
                count--;    // 개수 줄이기
                list.remove(i); // 리스트에서 삭제
                i--;    // 리스트 순회 인덱스 줄이기, 다음 리스트로 가기위해
            }
        }
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        int t = 0;  // 시간

        while (count != 0) {    // 치즈 개수가 0이 아니면
            t++;    // 시간 카운트

            visited = new boolean[N][M];    // 방문배열 초기화
            BFS(0, 0);  // BFS, 외부공기 찾기

            meltingCheese();    // 치즈 녺이기
        }

        System.out.println(t);  // 총 걸린 시간
    }
}
