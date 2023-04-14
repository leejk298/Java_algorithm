import java.util.*;

public class 뭉친K_구름Level {
    static int N, x, y, K;      // 크기, 좌표, 기준
    static int[] dx = {-1, 1, 0, 0};    // 4방향
    static int[] dy = {0, 0, -1, 1};
    static int[][] map; // 맵
    static boolean[][] visited; // 방문배열
    static int distance;    // 거리, 크기

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);    // 입력받기

        N = sc.nextInt();   // 배열 크기
        map = new int[N][N];    // 초기화
        visited = new boolean[N][N];

        x = sc.nextInt();   // 좌표
        y = sc.nextInt();

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();   // 맵 저장

        List<Integer> list = new ArrayList<>(); // 결과 리스트

        K = map[x - 1][y - 1];  // 기준값 K
        for(int i = 0; i < N; i++) {    // 행
            for(int j = 0; j < N; j++) {    // 열
                if(map[i][j] == K && !visited[i][j]) {  // 기준과 같고 방문하지않았으면
                    BFS(i, j);  // BFS 호출
                    list.add(distance); // 결과 리스트에 크기 저장
                    distance = 0;   // 초기화
                }
            }
        }

        Collections.sort(list); // 오름차순 정렬

        System.out.print(list.get(list.size() - 1) + 1);	// 자기 자신 포함하여 가장 큰 구름 출력
    }

    public static void BFS(int nx, int ny) {    // BFS
        Queue<int[]> queue = new LinkedList<>();    // 큐

        queue.offer(new int[] {nx, ny});    // 초기값 삽입
        visited[nx][ny] = true; // 방문여부 갱신

        while(!queue.isEmpty()) {   // 비어있지 않으면
            int[] now = queue.poll();   // 하나 꺼내어
            int nowX = now[0], nowY = now[1];   // 좌표

            for(int i = 0; i < 4; i++) {    // 4방향
                int tmpX = nowX + dx[i], tmpY = nowY + dy[i];   // 좌표 갱신

                if(tmpX < 0 || tmpX >= N || tmpY < 0 || tmpY >= N)  // 유효하지않으면 건너뛰기
                    continue;

                if(map[tmpX][tmpY] == K && !visited[tmpX][tmpY]) {  // K값과 같고 방문하지않았으면
                    visited[tmpX][tmpY] = true; // 방문여부 갱신
                    distance++; // 크기 갱신
                    queue.offer(new int[] {tmpX, tmpY});    // 큐에 삽입
                }
            }
        }
    }
}