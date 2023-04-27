import java.util.*;
/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2
 */

public class 영역구하기_백준 {
    static int N, M, K, count;  // 크기
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> list;  // 결과배열

    public static void init() { // 초기화
        Scanner sc = new Scanner(System.in);    // 입력

        N = sc.nextInt();   // 크기
        M = sc.nextInt();
        K = sc.nextInt();   // 좌표 개수

        // 초기화
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < K; i++) {    // 개수만큼
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int j = y1; j < y2; j++)    // 영역칠하기
                for(int k = x1; k < x2; k++)
                    map[j][k] = 1;  // 1
        }
    }

    public static boolean isValidPos(int x, int y) {    // 유효한 좌표인지
        return (x < 0 || x >= N || y < 0 || y >= M);
    }

    public static void BFS(int x, int y) {  // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {x, y});  // 시작점 삽입
        visited[x][y] = true;   // 방문여부 갱신
        count++;    // 개수 카운트

        while(!queue.isEmpty()) {   // 큐가 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어

            int nowX = now[0], nowY = now[1];   // 좌표
            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 다음 좌표

                if (isValidPos(tmpX, tmpY) || visited[tmpX][tmpY])  // 유효한 좌표인지
                    continue;

                if (map[tmpX][tmpY] == 0) { // 0이면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    count++;    // 개수 카운트
                    queue.offer(new int[]{tmpX, tmpY}); // 큐에 삽입
                }
            }
        }
    }

    public static void main(String[] args) {

        init(); // 초기화

        list = new ArrayList<>();   // 결과배열 선언
        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < M; j++) {    // 열
                if(map[i][j] == 0 && !visited[i][j]) {  // 0이면서 방문한 적이 없으면
                    BFS(i, j);  // BFS
                    list.add(count);    // 결과 배열에 저장
                    count = 0;  // 영역 크기 초기화
                }
            }
        }

        Collections.sort(list); // 오름차순 정렬

        System.out.println(list.size());    // 영역 개수 출력
        for(int i = 0; i < list.size(); i++)    // 영역 개수만큼
            System.out.print(list.get(i) + " ");    // 크기 출력
    }
}
