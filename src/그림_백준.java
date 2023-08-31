import java.util.*;
import java.io.*;

/*
6 5
1 1 0 1 1
0 1 1 0 0
0 0 0 0 0
1 0 1 1 1
0 0 1 1 1
0 0 1 1 1
 */

public class 그림_백준 {
    static int N, M, count; // 크기
    static int[][] map; // 입력배열
    static boolean[][] visited; // 방문배열
    static List<Integer> list;  // 결과리스트
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};

    public static void init() throws IOException {  // 초기화

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));   // 입력 버퍼
        StringTokenizer st = new StringTokenizer(bf.readLine());    // 한 줄 스트링

        N = Integer.parseInt(st.nextToken());   // 행
        M = Integer.parseInt(st.nextToken());   // 열

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];
        list = new ArrayList<>();

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

        queue.offer(new int[] {x, y});  // 큐에 시작점 삽입
        visited[x][y] = true;   // 시작점 방문
        count++;    // 개수 카운트

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 현재 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if(isNotValidPos(tmpX, tmpY) || visited[tmpX][tmpY])    // 유효한지
                    continue;

                if(map[tmpX][tmpY] == 1) {  // 1이면
                    visited[tmpX][tmpY] = true; // 방문
                    count++;    // 개수 카운트
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }

    public static void findPrintings() {    // 그림 찾기

        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 1 && !visited[i][j]) {  // 1이고 방문한 적이 없으면
                    BFS(i, j);  // BFS
                    list.add(count);    // 리스트에 개수 저장
                    count = 0;  // 개수 초기화
                }
            }
        }

        Collections.sort(list, Collections.reverseOrder()); // 리스트, 내림차순 정렬

        System.out.println(list.size());    // 리스트 크기 출력

        if(list.size() == 0)    // 0이면
            System.out.println(0);  // 0 출력
        else    // 0이 아니면
            System.out.println(list.get(0));    // 최대값 출력
    }

    public static void main(String[] args) throws IOException {

        init(); // 초기화

        findPrintings();    // 그림 찾기
    }
}